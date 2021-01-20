package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.widget.CompoundButton
import android.widget.ImageButton
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_mode.*

class ModeActivity   : AppCompatActivity() {

  /*  private Switch myswitch

    override fun onCreate(savedInstanceState: Bundle?) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            setTheme(R.style.darktheme)
        }
        else
        {
            setTheme(R.style.AppTheme)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode)
        myswitch =findViewById(R.id.myswitch)
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES)
        {
            myswitch.isChecked = true


        }
        myswitch.setOnCheckedChangeListener { buttonView, isChecked ->

   if (isChecked)
   {
       AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
       restartApp()
   }
            else
   {
       AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
       restartApp()
   }
        }

    }

    public fun restartApp()
    {
        val intent = Intent(this, ModeActivity::class.java)
        startActivity(intent)
        finish()
    }*/
}