package de.mustafagercek.library

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.widget.FrameLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter


class LoadingButton @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private var button: Button
    private var progressBar: ProgressBar
    private var text: String? = null
    private var buttonColor: Int = 0
    private var textColor: Int = 0

    companion object {

        @JvmStatic
        @BindingAdapter("bind:onButtonClick")
        fun setOnButtonClick(view: LoadingButton, listener: View.OnClickListener) {
            view.button.setOnClickListener(listener)
        }

        @JvmStatic
        @BindingAdapter("bind:buttonColor")
        fun setButtonColor(view: LoadingButton, color: Int) {
            view.buttonColor = color
            view.drawButton()
        }

        @JvmStatic
        @BindingAdapter("bind:textColor")
        fun setTextColor(view: LoadingButton, color: Int) {
            view.textColor = color
            view.drawButton()
        }

        @JvmStatic
        @BindingAdapter("bind:buttonText")
        fun setButtonText(view: LoadingButton, text: String) {
            view.text = text
            view.button.text = text
        }
    }

    init {
        LayoutInflater.from(context).inflate(R.layout.loading_button, this, true)
        button = findViewById(R.id.btn)
        progressBar = findViewById(R.id.pb)
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.LoadingButton, 0, 0)
        text = a.getString(R.styleable.LoadingButton_buttonText)
        buttonColor = a.getColor(R.styleable.LoadingButton_buttonColor, 0)
        textColor = a.getColor(R.styleable.LoadingButton_textColor, 0)
        drawButton()
    }

    fun setButtonOnClickListener(onClick: View.OnClickListener?) {
        button.setOnClickListener(onClick)
    }

    fun setButtonColor(color: Int) {
        buttonColor = color
        drawButton()
    }

    fun setTextColor(color: Int) {
        textColor = color
        drawButton()
    }

    fun setButtonText(text: String) {
        this.text = text
        button.text = text
    }

    private fun drawButton() {
        button.text = text
        if (buttonColor != 0)
            button.backgroundTintList = ColorStateList.valueOf(buttonColor)

        if (textColor != 0) {
            button.setTextColor(textColor)
            progressBar.indeterminateTintList = ColorStateList.valueOf(textColor)
        } else {
            button.setTextColor(if (isColorDark(buttonColor)) Color.WHITE else Color.BLACK)
            progressBar.indeterminateTintList = ColorStateList.valueOf(if (isColorDark(buttonColor)) Color.WHITE else Color.BLACK)
        }
    }

    public fun onStartLoading() {
        button.text = ""
        button.isEnabled = false
        progressBar.visibility = View.VISIBLE
    }

    public fun onStopLoading() {
       button.isEnabled = true
        button.text = text
        progressBar.visibility = View.GONE
    }

    public fun isInProgress(): Boolean {
        return progressBar.visibility == View.VISIBLE
    }

}