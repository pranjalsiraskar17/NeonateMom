package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_nurseicon.*


class NurseIconActivity : AppCompatActivity() {
    var name=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name=intent.getStringExtra(NurseGrowthActivity.USER_KEY)
        Log.d("msg1",name)
        setContentView(R.layout.activity_nurseicon)
        editText9.setText(name)
        nurseicon_button.setOnClickListener {
            performRegister()

        }
    }

    private fun performRegister() {
        val motheremail = editText9.text.toString()
        val babyhead = editText2.text.toString()
        val babylength = editText3.text.toString()
        val babyweight = editText4.text.toString()
        val actualbirth = editText6.text.toString()
        val estimatedbirth = editText8.text.toString()


        if (motheremail.isEmpty() || babyhead.isEmpty() || babylength.isEmpty() || babyweight.isEmpty() || actualbirth.isEmpty() || estimatedbirth.isEmpty()) {
            Toast.makeText(this, "Please enter all the credentials", Toast.LENGTH_SHORT).show()
            return
        }
        else {

                    saveUserToFirebaseDatabase()
            Toast.makeText(this, "Your response has been recorded", Toast.LENGTH_SHORT).show()
                    return
                }

        }


    private fun saveUserToFirebaseDatabase() {
        val uid = FirebaseAuth.getInstance().uid ?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/users")
        val motheremail = editText9.text.toString()
        val baby_head = editText2.text.toString()
        val baby_length = editText3.text.toString()
        val baby_weight = editText4.text.toString()
        val actual_date = editText6.text.toString()
        val estimated_date = editText8.text.toString()
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {


                p0.children.forEach {

                    val user4 = it.getValue(User::class.java)
                    if (motheremail == user4?.name) {
                        if (user4?.neonat == "Mom") {
                            val userid = user4?.uid
                            val ref = FirebaseDatabase.getInstance().getReference("/users/$userid")
                            ref.child("baby_head").setValue(baby_head)
                            ref.child("baby_length").setValue(baby_length)
                            ref.child("baby_weight").setValue(baby_weight)
                            ref.child("actual_date").setValue(actual_date)
                            ref.child("estimated_date").setValue(estimated_date)
                        }
                    }
                }

                }

            override fun onCancelled(p0: DatabaseError) {

            }
            })
    }
}

