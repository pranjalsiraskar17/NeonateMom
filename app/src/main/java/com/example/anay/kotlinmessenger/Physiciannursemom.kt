

package com.example.anay.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


import kotlinx.android.synthetic.main.activity_growthicon.*

import com.google.firebase.database.FirebaseDatabase


class Physiciannursemom : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physiciannursemom)
        val email=intent.getStringExtra("email")
        val imageButton1 = findViewById<ImageButton>(R.id.growth_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this,Physicianmomdisplay::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }

        val imageButton2 = findViewById<ImageButton>(R.id.guide_button)
        imageButton2?.setOnClickListener {
            val intent = Intent(this,Physicianmomdisplay::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
    }
}
