package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.medicalterms.*

import kotlinx.android.synthetic.main.medicaltermsmeaning.*

class GuideDisplayActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.medicalterms)
       button4.setOnClickListener{
           val intent = Intent(this, medicaltermsmeaning::class.java)
           intent.putExtra("email","Also known as corrected age, is a term used most appropriately to describe children up to 3 years of age who were born preterm, “corrected age” or adjusted age” is calculated by subtracting the number of weeks born before 40 weeks of gestation from thechronological age.")
           intent.putExtra("heading","Adjusted Age")
           startActivity(intent)


       }
        button5.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","A safe and painless method to measure the electrical activity of the cochlear nerve (hearing nerve) and auditory nerve pathways in the brainstem in response to sound.")
            intent.putExtra("heading","Auditory Brainstem Response Test")
            startActivity(intent)

        }
        button6.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","A heart rate less than 100, slower than normal for an infant.")
            intent.putExtra("heading","Bradycardia")
            startActivity(intent)

        }
        button.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","A chronic lung disorder that is most common among children who were born prematurely, with low birth weights, and who received prolonged mechanical ventilation.")
            intent.putExtra("heading","Broncho-pulmonary Dysplasia(BPD)")
            startActivity(intent)

        }
        button2.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","A slender tube that can be inserted into a body cavity or duct.")
            intent.putExtra("heading","Cannula")
            startActivity(intent)

        }
        button3.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","A hollow flexible tube for insertion into a body cavity, duct, or vessel to allow the passage of fluids or distend a passageway. Its uses include the drainage of urine from the bladder through the urethra or insertion through a blood vessel into the heart for diagnostic purposes.")
            intent.putExtra("heading","Catheter")
            startActivity(intent)

        }
        button7.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","Also known as Family-Centered Care, is a term used in NICUs to reduce the stress of the NICU experience on premature babies, including many different practices such as: swaddling, noise levels, skin-to-skin care, Individual Care Plans, parental involvement, positioning for development, expanding visitation policies, lactation support, and music therapy.")
            intent.putExtra("heading","Developmental Care")
            startActivity(intent)

        }
        button8.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","The failure to meet certain milestones such as rolling, sitting, walking, and talking at the average age.")
            intent.putExtra("heading","Developmental Delays")
            startActivity(intent)

        }
        button9.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","Often referred to as just Echo, is the use of ultrasound to view the structure and function of the heart.")
            intent.putExtra("heading","Echo-cardiogram")
            startActivity(intent)

        }
        button11.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","A conductor used to make contact with a nonmetallic part of a circuit.")
            intent.putExtra("heading","Electrodes")
            startActivity(intent)

        }
        button13.setOnClickListener{
            val intent = Intent(this, medicaltermsmeaning::class.java)
            intent.putExtra("email","A physician with seven years of training in diagnosing and treating diseases of the GI tract and digestive system. ")
            intent.putExtra("heading","Gastro-enterologist")
            startActivity(intent)

        }
        val back = findViewById<TextView>(R.id.textView16)
        back.setOnClickListener{
            super.onBackPressed()


        }
        val home = findViewById<TextView>(R.id.textView13)
        home.setOnClickListener{
            val intent = Intent(this, PhysicianGrowthGuideExperienceActivity::class.java)
            startActivity(intent)


        }
    }
}