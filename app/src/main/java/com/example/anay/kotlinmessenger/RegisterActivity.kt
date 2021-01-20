package com.example.anay.kotlinmessenger

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.*
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


import kotlinx.android.synthetic.main.activity_main.*

import com.google.firebase.database.FirebaseDatabase


class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        register_button_register.setOnClickListener {
            performRegister()


        }
            already_have_account_text_view.setOnClickListener {
                //launch the login activity/page
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

    }


    private fun performRegister(){
        val email = email_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()
        val mobile=mobile_edittext_register.text.toString()
        val admitdate=address_edittext_register.text.toString()
        val name=name_edittext_register.text.toString()
        val attending_nurse=attendingnurse.text.toString()

        d("RegisterActivity", "email is " + email)
        d("RegisterActivity", "password is $password")

        if (email.isEmpty() || password.isEmpty() || mobile.isEmpty() || admitdate.isEmpty() || name.isEmpty() || attending_nurse.isEmpty())
        {
            Toast.makeText(this, "Please enter all the credentials",Toast.LENGTH_SHORT ).show()
            return
        }
        else
        {
        if (!isValidPhone())
        {
            Toast.makeText(this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show()
            return
        }
        else if (!isValidName())
        {
            Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show()
            return
        }
        else if (!isValidNurse())
        {
            Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show()
            return
        }
        }
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    return@addOnCompleteListener
                }






                Log.d("Main", "Successfully created user with uid: ${it.result?.user?.uid}")
                saveUserToFirebaseDatabase()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            }
            .addOnFailureListener{
                Log.d("Main","Failed to create user: ${it.message}")
                Toast.makeText(this, "Failed to create user: ${it.message}",Toast.LENGTH_SHORT ).show()
            }

    }

    private fun isValidName(): Boolean {
        val name1=name_edittext_register.text.toString()
        val regex = "^[\\p{L} .'-]+$"
        return name1.matches(regex.toRegex())
    }
    private fun isValidNurse(): Boolean {
        val name2=attendingnurse.text.toString()
        val regex = "^[\\p{L} .'-]+$"
        return name2.matches(regex.toRegex())
    }

    private fun isValidPhone(): Boolean {
        val phone1=mobile_edittext_register.text.toString()
        var flag=true
        if (phone1.length<10 || phone1.length>10)
        {
            flag=false
        }
        else
        {
            return android.util.Patterns.PHONE.matcher(phone1).matches()
        }

        return flag
    }

    private fun saveUserToFirebaseDatabase() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
        val neonat="Mom"
        val baby_head=""
        val baby_length=""
        val baby_weight=""
        val actual_date=""
        val estimated_date=""
        val user = User(uid,baby_head,baby_length,baby_weight, name_edittext_register.text.toString(),mobile_edittext_register.text.toString(),address_edittext_register.text.toString(),email_edittext_register.text.toString(),password_edittext_register.text.toString(),neonat,actual_date,estimated_date,attendingnurse.text.toString())

        ref.setValue(user)
            .addOnSuccessListener {
                Log.d("RegisterActivity","Stored to database")
            }
            .addOnFailureListener{
                Log.d("RegisterActivity","Failed: ${it.message}")
            }
    }
}
class User(val uid: String,val baby_head: String,val baby_length: String,val baby_weight: String, val name: String,val mobile: String,val admitdate: String,val email: String,val password: String, val neonat: String,val actual_date:String,val estimated_date:String,val attending_nurse: String)
{
    constructor() :this("","","","","","","","","","","","","")


}