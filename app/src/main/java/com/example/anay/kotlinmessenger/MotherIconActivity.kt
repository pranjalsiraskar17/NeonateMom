package com.example.anay.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


import kotlinx.android.synthetic.main.activity_mothericon.*

import com.google.firebase.database.FirebaseDatabase


class MotherIconActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mothericon)
        val email=intent.getStringExtra("email")
        val imageButton1 = findViewById<ImageButton>(R.id.growth_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, GrowthActivity::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
        val imageButton2=findViewById<ImageButton>(R.id.guide_button)
        imageButton2?.setOnClickListener {
            val intent = Intent(this, GuideActivity::class.java)
            startActivity(intent)
        }
        val imageButton3 = findViewById<ImageButton>(R.id.experience_button)
        imageButton3?.setOnClickListener {
            val intent = Intent(this, chooser1::class.java)
            intent.putExtra("email",email)
            startActivity(intent)

        }
        val imageButton4=findViewById<ImageButton>(R.id.experience_button1)
        imageButton4?.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        val home = findViewById<TextView>(R.id.textView13)
        home.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)


        }

    }
}
