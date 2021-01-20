package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_equipments.*
import kotlinx.android.synthetic.main.medicalterms.*
import kotlinx.android.synthetic.main.medicaltermsmeaning.*

class Equipments: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_equipments)
        button104.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","This monitor displays a baby's heart and breathing rates and patterns on a screen. Wires from the monitor are attached to adhesive patches on the skin of the baby's chest, abdomen, and leg.")
            intent.putExtra("heading","Heart/Cardiorespiratory Monitor")
            startActivity(intent)


        }
        button105.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","Blood pressure is measured using a small cuff placed around the baby's upper arm or leg. Periodically, a blood pressure monitor pumps up the cuff and measures the level of blood pressure. Some babies need continuous blood pressure monitoring. This can be done using a catheter (small tube) in one of the baby's arteries.")
            intent.putExtra("heading","Blood Pressure Monitor")
            startActivity(intent)

        }
        button106.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","A temperature probe is placed on the baby's skin with an adhesive patch. A wire connects the temperature probe to the overhead warmer (or isolette) to help regulate the heat needed to keep the baby warm.")
            intent.putExtra("heading","Temperature")
            startActivity(intent)

        }
        button107.setOnClickListener{
            val intent = Intent(this,equipmentsmeaning::class.java)
            intent.putExtra("email","This machine measures the amount of oxygen in the baby's blood through the skin. A tiny light is taped to the baby's finger or toe, or in very tiny babies, a foot or hand. A wire connects the light to the monitor where it displays the amount of oxygen in the baby's red blood cells.")
            intent.putExtra("heading","Pulse Oximeter")
            startActivity(intent)

        }
        button108.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","This machine measures the amount of oxygen and carbon dioxide in the baby's skin. A small circular pad is taped on the baby's skin. The pad warms a small area of skin underneath and measures oxygen, carbon dioxide, or both. A wire connects the pad to the monitor and displays the levels. Because the transcutaneous monitor heats the skin, it must be moved to different places on the baby's skin periodically. The heating may leave a temporary reddened spot on the baby's skin, but this will fade.")
            intent.putExtra("heading","Transcutaneous Oxygen")
            startActivity(intent)

        }
        button109.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","Ultrasound uses high-frequency sound waves and a computer to create images of blood vessels, tissues, and organs. Ultrasounds are used to view internal organs as they function, and to assess blood blow through various vessels. In the NICU, ultrasound may be used to examine the heart, abdomen, and internal structures of the baby's brain. Ultrasound is painless and provides much information about a baby's health.")
            intent.putExtra("heading"," Ultrasound")
            startActivity(intent)

        }
        button110.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","Portable X-ray machines may be brought to the baby's bedside in the NICU. X-rays use invisible electromagnetic energy beams to produce images of internal tissues, bones, and organs on film. X-rays are taken for many reasons including checking the placement of catheters and other tubes, looking for signs of lung problems, such as infant respiratory distress syndrome, and checking for signs of bowel problems.")
            intent.putExtra("heading","X-ray")
            startActivity(intent)

        }
        button111.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","A CT scan is a diagnostic imaging procedure that uses a combination of X-rays and computer technology to produce horizontal, or axial, images (often called slices) of the body. A CT scan shows detailed images of any part of the body, including the bones, muscles, fat, and organs. CT scans are more detailed than general X-rays. CT scans also minimize exposure to radiation. CT scans are sometimes done to assess bleeding inside a baby's head. A CT scan is done in a special room and the baby may need a sedative medication so that he or she will be motionless for the exam.")
            intent.putExtra("heading","Computed Tomography")
            startActivity(intent)

        }
        button112.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","MRI is a diagnostic procedure that uses a combination of a large magnet, radio frequencies, and a computer to produce detailed images of organs and structures within the body. Like a CT scan, MRI is performed in a special area of the hospital. It is often done to examine a baby's brain stem, spinal cord, and soft tissues. The baby will need a sedative medication so that he or she will be motionless for the exam.")
            intent.putExtra("heading"," Magnetic Resonance Imaging(MRI)")
            startActivity(intent)

        }
        button113.setOnClickListener{
            val intent = Intent(this,equipmentsmeaning::class.java)
            intent.putExtra("email","This tube is placed through the baby's mouth or nose into the trachea (windpipe). The ET tube is held in place with special tape and connects to a mechanical ventilator (breathing machine) with flexible tubing. An X-ray is used to check the tube's placement. When a baby has an ET tube, he or she is unable to make sounds or cry.")
            intent.putExtra("heading","Endotracheal tube(ET)")
            startActivity(intent)

        }

        button114.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","This machine helps babies who can not breathe on their own or who need help taking bigger breaths. High frequency ventilators give hundreds of tiny puffs of air to help keep a baby's airways open. Ventilators can also deliver extra oxygen to the baby. ")
            intent.putExtra("heading","Respirator/Mechanical Ventilator")
            startActivity(intent)

        }
        button115.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","Through small tubes that fit into the baby's nostrils, called nasal CPAP, this machine pushes a continuous flow of air or oxygen to the airways to help keep tiny air passages in the lungs open. CPAP may also be given through an ET tube. ")
            intent.putExtra("heading","Continuous Positive Airway Pressure(CPAP)")
            startActivity(intent)

        }
        button116.setOnClickListener{
            val intent = Intent(this, equipmentsmeaning::class.java)
            intent.putExtra("email","This is a special technique for babies with respiratory disease that does not respond to maximum medical care. With ECMO, blood from the baby's vein is pumped through an artificial lung where oxygen is added and carbon dioxide is removed. The blood is then returned back to the baby. ECMO is only used in specialized NICUs. ")
            intent.putExtra("heading","Extracorporeal Membrane Oxygenation(ECMO)")
            startActivity(intent)

        }
        val back = findViewById<TextView>(R.id.textView16)
        back.setOnClickListener{
            val intent = Intent(this, PhysicianGuideActivity::class.java)
            startActivity(intent)


        }
        val home = findViewById<TextView>(R.id.textView13)
        home.setOnClickListener{
            val intent = Intent(this, PhysicianGrowthGuideExperienceActivity::class.java)
            startActivity(intent)


        }
    }
}