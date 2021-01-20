package com.example.anay.kotlinmessenger
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_growthdisplay.*
import kotlinx.android.synthetic.main.physiciangrowthdisplay.view.*

class PhysiciangrowthdisplayActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_growthdisplay)


        fetchusers()
    }

    private fun fetchusers(){
        val ref=FirebaseDatabase.getInstance().getReference("/users")
        ref.addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(p0: DataSnapshot) {
                val adapter=GroupAdapter<ViewHolder>()
                val email=intent.getStringExtra("email")
                p0.children.forEach{


                    val user = it.getValue(User::class.java)
                    Log.d("NewMessage2", email)
                    if (user!=null && user?.neonat=="Mom") {

                        adapter.add(UserItem22(user))
                        //adapter.add(UserItem(user))
                        // adapter.add(UserItem(user?.baby_head))
                        //adapter.add(UserItem(user?.baby_length))
                        //adapter.add(UserItem(user?.baby_weight))
                    }
                }
                id_display_growth.adapter=adapter
            }
            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
}

class UserItem22(val user: User): Item<ViewHolder>(){


    override fun bind(viewHolder: ViewHolder, position: Int) {

        viewHolder.itemView.textView15.text=user.name
        viewHolder.itemView.id_body_head1.text=user.baby_head
        viewHolder.itemView.id_body_length1.text=user.baby_length
        viewHolder.itemView.id_body_weight1.text=user.baby_weight
    }
    override fun getLayout(): Int {


        return R.layout.physiciangrowthdisplay
    }
}