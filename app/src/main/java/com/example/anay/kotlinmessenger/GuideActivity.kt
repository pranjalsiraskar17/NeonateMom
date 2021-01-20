package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.TextView

class GuideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide)
        val email=intent.getStringExtra("email")
        val imageButton1 = findViewById<ImageButton>(R.id.growth_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, GuideDisplayActivity::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
        val imageButton2 = findViewById<ImageButton>(R.id.guide_button)
        imageButton2?.setOnClickListener {
            val intent = Intent(this, Equipments::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
        val imageButton3 = findViewById<ImageButton>(R.id.experience_button)
        imageButton3?.setOnClickListener {
            val intent = Intent(this, FAQ::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
        val back = findViewById<TextView>(R.id.textView16)
        back.setOnClickListener{
            val intent = Intent(this, MotherIconActivity::class.java)
            startActivity(intent)


        }
        val home = findViewById<TextView>(R.id.textView13)
        home.setOnClickListener{
            val intent = Intent(this, MotherIconActivity::class.java)
            startActivity(intent)


        }
    }
}