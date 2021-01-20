package com.example.anay.kotlinmessenger

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.medicalterms.*
import kotlinx.android.synthetic.main.medicaltermsmeaning.*

class equipmentsmeaning : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.equipmentsmeaning)
        val email=intent.getStringExtra("email")
        val heading=intent.getStringExtra("heading")
        textView7.text=email
        textView3.text=heading
    }
}
