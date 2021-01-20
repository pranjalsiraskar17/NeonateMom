package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.ImageButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_growthdisplay.*
import kotlinx.android.synthetic.main.growthdisplay.view.*

class Physicianmomdisplay : AppCompatActivity() {
    var email=""
    var name=""
    var mail=""

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nursegrowth)
        val uid=FirebaseAuth.getInstance().uid
        if (uid==null)
        {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        //supportActionBar?.title="Registered Mom/s"
        email=intent.getStringExtra("email")
        val imageButton1 = findViewById<ImageButton>(R.id.growth_button)
        imageButton1?.setOnClickListener {
            Log.d("Newmsg2",email)
            setContentView(R.layout.activity_nursegrowthdisplay)
            fetchusers()
        }
        val imageButton3 = findViewById<ImageButton>(R.id.imageButton3)
        imageButton3?.setOnClickListener {
            Log.d("Newmsg2",email)
            setContentView(R.layout.activity_nurseupdategrowth)
            fetchusers1()
        }
    }


    private fun fetchusers(){
        val ref= FirebaseDatabase.getInstance().getReference("/users")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {
                val adapter= GroupAdapter<ViewHolder>()
                p0.children.forEach{


                    val user = it.getValue(User::class.java)
                    if (user!=null && user?.neonat=="Mom") {

                        adapter.add(UsernurseItem11(user))
                        mail=user?.name
                        //adapter.add(UserItem(user))
                        // adapter.add(UserItem(user?.baby_head))
                        //adapter.add(UserItem(user?.baby_length))
                        //adapter.add(UserItem(user?.baby_weight))
                    }
                }

                adapter.setOnItemClickListener { item, view ->

                    val intent=Intent(view.context,PhysiciangrowthdisplayActivity::class.java)
                    intent.putExtra("email",mail)
                    startActivity(intent)
                }
                id_display_growth.adapter=adapter


            }
            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
    companion object {
        val USER_KEY="USER_KEY"
    }
    private fun fetchusers1(){

        val ref= FirebaseDatabase.getInstance().getReference("/users")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(p0: DataSnapshot) {
                val adapter= GroupAdapter<ViewHolder>()


                p0.children.forEach{


                    val user = it.getValue(User::class.java)
                    //Log.d("NewMessage2", email)
                    if (user!=null && user?.neonat=="Mom") {

                        adapter.add(UsernurseItem12(user))
                        //adapter.add(UserItem(user))
                        // adapter.add(UserItem(user?.baby_head))
                        //adapter.add(UserItem(user?.baby_length))
                        //adapter.add(UserItem(user?.baby_weight))
                    }
                }

                adapter.setOnItemClickListener { item, view ->

                    val userItem=item as UsernurseItem12
                    val intent=Intent(view.context, NurseIconActivity::class.java)
                    intent.putExtra(USER_KEY,userItem.user.name)
                    startActivity(intent)
                }
                id_display_growth.adapter=adapter

            }
            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
}
class UsernurseItem11(val user: User): Item<ViewHolder>(){


    override fun bind(viewHolder: ViewHolder, position: Int) {


        viewHolder.itemView.id_body_head1.text=user.name
    }
    override fun getLayout(): Int {


        return R.layout.nurseupdategrowth
    }
}
class UsernurseItem12(val user: User): Item<ViewHolder>(){


    override fun bind(viewHolder: ViewHolder, position: Int) {


        viewHolder.itemView.id_body_head1.text=user.name
    }
    override fun getLayout(): Int {


        return R.layout.nurseupdategrowth
    }
}