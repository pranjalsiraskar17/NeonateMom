package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton

class SettingsActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val imageButton1 = findViewById<ImageButton>(R.id.growth_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, FontActivity::class.java)
            startActivity(intent)
        }

        val imageButton2 = findViewById<ImageButton>(R.id.experience_button)
        imageButton2?.setOnClickListener {
            val intent = Intent(this, ModeActivity::class.java)
            startActivity(intent)
        }

    }
}