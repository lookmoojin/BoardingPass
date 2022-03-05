package com.example.boardingpass

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.boardingpass.databinding.ViewBoardingPassDetailBinding

class BoardingPassDetailView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding: ViewBoardingPassDetailBinding by lazy {
        ViewBoardingPassDetailBinding.inflate(LayoutInflater.from(context), this, false)
    }
    private var textTitle: String = ""
    private var textDetail: String = ""

    init {
        addView(binding.root)
        setupStyledAttributes(attrs)
        displayText()
    }

    private fun setupStyledAttributes(attrs: AttributeSet?) {
        attrs?.let { _attrs ->
            context.obtainStyledAttributes(_attrs, R.styleable.BoardingPassDetailView).apply {
                textTitle = getString(R.styleable.BoardingPassDetailView_text_title).orEmpty()
                textDetail = getString(R.styleable.BoardingPassDetailView_text_detail).orEmpty()
            }.recycle()
        }
    }

    private fun displayText() = with(binding) {
        titleTextView.text = textTitle
        detailTextView.text = textDetail
    }
}