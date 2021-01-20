

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


import kotlinx.android.synthetic.main.activity_growthicon.*

import com.google.firebase.database.FirebaseDatabase


class GrowthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_growthicon)
        val email=intent.getStringExtra("email")
        val imageButton1 = findViewById<ImageButton>(R.id.growth_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, GrowthDisplayActivity::class.java)
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
