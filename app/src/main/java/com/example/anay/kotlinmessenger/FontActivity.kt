package com.example.anay.kotlinmessenger

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.anay.kotlinmessenger.R.id.textView
import kotlinx.android.synthetic.main.activity_login.*
import android.view.WindowManager
import android.util.DisplayMetrics



class FontActivity  : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_font)

        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup1?.setOnCheckedChangeListener { group, checkedId ->

            if (R.id.smallFont==checkedId)
            {
                adjustFontScale(resources.configuration, 0.8F)

            }
            else if (R.id.mediumFont==checkedId) {
                adjustFontScale(resources.configuration, 1.0F)
            }
            else if(R.id.largeFont==checkedId)
            {
                adjustFontScale(resources.configuration, 1.4F)
            }

        }






    }

    private fun adjustFontScale(configuration: Configuration, scale: Float) {

        configuration.fontScale = scale
        val metrics = resources.displayMetrics
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(metrics)
        metrics.scaledDensity = configuration.fontScale * metrics.density
        baseContext.resources.updateConfiguration(configuration, metrics)

    }

}