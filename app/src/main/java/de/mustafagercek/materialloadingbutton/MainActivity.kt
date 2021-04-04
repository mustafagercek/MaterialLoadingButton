package de.mustafagercek.materialloadingbutton

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import de.mustafagercek.materialloadingbutton.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.presenter = this

        binding.loadingButton2.setButtonEnabled(false)
        val normal =
            ResourcesCompat.getFont(this, R.font.extra_bold);
        val normal2 =
            ResourcesCompat.getFont(this, R.font.comici);
        binding.loadingButton2.setFont(normal!!)
        binding.loadingButton.setFont(normal2!!)

    }


    fun doStuff(view: View) {
        binding.loadingButton.setButtonEnabled(false)
        Handler().postDelayed({
            binding.loadingButton.setButtonEnabled(true)
            binding.loadingButton2.setButtonEnabled(true)
        }, 500)
    }

    fun doStuff2(view: View) {
        binding.loadingButton2.onStartLoading()
        Handler().postDelayed({
            binding.loadingButton2.onStopLoading()
        }, 500)
    }

    fun doStuff3(view: View) {
        binding.loadingButton3.onStartLoading()
        Handler().postDelayed({
            binding.loadingButton3.onStopLoading()
        }, 500)
    }
}
