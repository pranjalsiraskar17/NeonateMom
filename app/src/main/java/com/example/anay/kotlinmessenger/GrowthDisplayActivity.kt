package com.example.anay.kotlinmessenger
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_growthdisplay.*
import kotlinx.android.synthetic.main.growthdisplay.view.*

class GrowthDisplayActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_growthdisplay)


        fetchusers()

        val back = findViewById<TextView>(R.id.textView16)
        back.setOnClickListener{
            val intent = Intent(this, GrowthActivity::class.java)
            startActivity(intent)


        }
        val home = findViewById<TextView>(R.id.textView13)
        home.setOnClickListener{
            val intent = Intent(this, MotherIconActivity::class.java)
            startActivity(intent)


        }
    }

    private fun fetchusers(){
        val ref=FirebaseDatabase.getInstance().getReference("/users")
        ref.addListenerForSingleValueEvent(object : ValueEventListener{

            override fun onDataChange(p0: DataSnapshot) {
                val adapter=GroupAdapter<ViewHolder>()
                val email=intent.getStringExtra("email")
                p0.children.forEach{


                    val user = it.getValue(User::class.java)
                    //Log.d("NewMessage2", email)
                    if (user!=null && email==user?.email) {

                         adapter.add(UserItem(user))
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

class UserItem(val user: User): Item<ViewHolder>(){


    override fun bind(viewHolder: ViewHolder, position: Int) {


        viewHolder.itemView.id_body_head1.text=user.baby_head
        viewHolder.itemView.id_body_length1.text=user.baby_length
        viewHolder.itemView.id_body_weight1.text=user.baby_weight
    }
    override fun getLayout(): Int {


        return R.layout.growthdisplay
    }
}