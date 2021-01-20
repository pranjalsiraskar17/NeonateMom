package com.example.anay.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


import kotlinx.android.synthetic.main.activity_main.*

import com.google.firebase.database.FirebaseDatabase


class RegisterIconActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registericon)
        val imageButton1 = findViewById<ImageButton>(R.id.mother_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        val imageButton2 = findViewById<ImageButton>(R.id.physician_button)
        imageButton2?.setOnClickListener {
            val intent = Intent(this, PhysicianActivity::class.java)
            startActivity(intent)
        }
        val imageButton3 = findViewById<ImageButton>(R.id.nurse_button)
        imageButton3?.setOnClickListener {
            val intent = Intent(this, NurseActivity::class.java)
            startActivity(intent)
        }
        val imageButton4 = findViewById<ImageButton>(R.id.pediatrician_button)
        imageButton4?.setOnClickListener {
            val intent = Intent(this, PediatricianActivity::class.java)
            startActivity(intent)
        }

    }
}