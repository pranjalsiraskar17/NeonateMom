package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_nurse.*

class NurseGrowthGuideExperienceActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nursegrowthguideexperience)
        val email=intent.getStringExtra("email")
        Log.d("Newmsg",email)
        val imageButton1 = findViewById<ImageButton>(R.id.growth_button)
        imageButton1?.setOnClickListener {
            val intent = Intent(this, NurseGrowthActivity::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
        val imageButton2 = findViewById<ImageButton>(R.id.guide_button)
        imageButton2?.setOnClickListener {
            val intent = Intent(this, NurseGuideActivity::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
        val imageButton3 = findViewById<ImageButton>(R.id.experience_button)
        imageButton3?.setOnClickListener {
            val intent = Intent(this, chooser1::class.java)
            intent.putExtra("email",email)
            startActivity(intent)

        }
        val imageButton4 = findViewById<ImageButton>(R.id.experience_button1)
        imageButton3?.setOnClickListener {
            val intent = Intent(this, chooser1::class.java)
            intent.putExtra("email",email)
            startActivity(intent)
        }
        val back = findViewById<TextView>(R.id.textView16)
        back.setOnClickListener{
            val intent = Intent(this, NurseGrowthGuideExperienceActivity::class.java)
            startActivity(intent)


        }
        val home = findViewById<TextView>(R.id.textView13)
        home.setOnClickListener{
            val intent = Intent(this, NurseGrowthGuideExperienceActivity::class.java)
            startActivity(intent)


        }



    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId)
        {
            R.id.menu_settings ->{
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)

            }
            R.id.menu_sign_out ->{
              FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}