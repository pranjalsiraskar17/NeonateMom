package com.example.anay.kotlinmessenger



import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){

    lateinit var mGoogleSignInClient:  GoogleSignInClient
    lateinit var gso:GoogleSignInOptions
    val RC_SIGN_IN: Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login_button_login.setOnClickListener {
            performLogin()
        }

        back_to_register_textview.setOnClickListener{
            val intent = Intent(this, RegisterIconActivity::class.java)
            startActivity(intent)

        }

        val signIn=findViewById<View>(R.id.signInBtn) as SignInButton
        gso=GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        mGoogleSignInClient= GoogleSignIn.getClient(this, gso)
       signIn.setOnClickListener {
           view: View? -> signInGoogle ()
       }


    }
    private fun signInGoogle ()
    {
          val signInIntent: Intent = mGoogleSignInClient.signInIntent
          startActivityForResult(signInIntent,RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==RC_SIGN_IN)
        {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleResult(task)
        }
    }

    private fun handleResult(completedTask: Task<GoogleSignInAccount>)
    {
        try
        {
            val account: GoogleSignInAccount ?= completedTask.getResult(ApiException::class.java)

        }catch (e: ApiException)
        {
            Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show()
        }
    }
    private fun performLogin() {
        val email = email_edittext_login.text.toString()
        val password = password_edittext_login.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill out email/pw.", Toast.LENGTH_SHORT).show()
            return
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful)
                {
                    return@addOnCompleteListener
                }
                else
                {
                    Log.d("Login", "Successfully logged in: ${it.result?.user?.uid}")
                    val ref = FirebaseDatabase.getInstance().getReference("/users")
                    ref.addListenerForSingleValueEvent(object: ValueEventListener
                    {
                        override fun onDataChange(p0: DataSnapshot) {


                            p0.children.forEach {

                                val user = it.getValue(User::class.java)
                                if (email==user?.email)
                                {
                                    if(user?.neonat=="Mom")
                                    {
                                        val intent = Intent(this@LoginActivity,MotherIconActivity::class.java)
                                        intent.putExtra("email",email)
                                        startActivity(intent)
                                    }
                                    else if(user?.neonat=="Physician")
                                    {
                                        val intent = Intent(this@LoginActivity,PhysicianGrowthGuideExperienceActivity::class.java)
                                        intent.putExtra("email",email)
                                        startActivity(intent)
                                    }
                                    else if(user?.neonat=="Nurse")
                                    {

                                        val intent = Intent(this@LoginActivity,NurseGrowthGuideExperienceActivity::class.java)
                                        intent.putExtra("email",email)
                                        startActivity(intent)
                                    }
                                    else if(user?.neonat=="Pediatrician")
                                    {

                                    }

                                    //Log.d("NewMessage",user?.neonat)
                                }


                            }


                        }

                        override fun onCancelled(p0: DatabaseError) {

                        }
                    })
                    }
                }

            .addOnFailureListener {
                Toast.makeText(this, "Failed to log in: ${it.message}", Toast.LENGTH_SHORT).show()

            }
    }

}

