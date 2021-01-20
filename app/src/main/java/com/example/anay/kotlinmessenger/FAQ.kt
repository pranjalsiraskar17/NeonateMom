package com.example.anay.kotlinmessenger

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.medicalterms.*
import kotlinx.android.synthetic.main.medicaltermsmeaning.*

class FAQ: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.faq)
        button4.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email","This question abounds among family and friends who are so confused as to why you are saying that your baby, who was born 4 months ago, is 1 month adjusted. What is up? Basically actual age, or chronological age, is based on when your baby was born. His adjusted age, or corrected age, is how old he would be according to his due date, if he was born â€œon time.â€\u009D Babies who are born premature had much more developing to do inside the womb. Since they are having to do their developing outside the womb, we have to adjust their age accordingly. Since my son was 3 months premature, when he was 4 months old, doctors measured him, weighed him and checked his developmental progress by his adjusted age, which was 1 month old. If he was doing things typical of a 1-month old, he was on track.")
            intent.putExtra("heading","What is adjusted age vs actual age?")
            startActivity(intent)


        }
        button5.setOnClickListener{
            val intent = Intent(this,FAQmeaning::class.java)
            intent.putExtra("email","Nope! There are many milestones baby must reach before he can go home, and weight is not an indicator that those goals have been accomplished. There are 10-pound babies in NICU who cannot breathe, and 4-pound babies who can. Before baby can go home, he must learn to breathe efficiently on his own, hold his own temperature and take all feedings by mouth, to name a few. Baby's weight does not ensure that any of those milestones have been reached.")
            intent.putExtra("heading","Can't just baby go home when he hits a certain weight?")
            startActivity(intent)

        }
        button6.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email","It is of course hard to say for sure! The risk is there. Thankfully, a preemie's development is constantly monitored, usually up until at least 2 years old, so if there are any issues the hope is that it will be caught early. Many preemies have no long-term or even short-term developmental issues, but others do.")
            intent.putExtra("heading","Will there be long-term developmental issues?")
            startActivity(intent)

        }
        button.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email","The answer to this will be different for every preemie baby. Because honestly, for some, the answer is yes. We brought our son home one week past his due date, weighing 8lbs, 6ozs (a typical newborn weight), and he had no medical needs. He was like a perfectly typical newborn baby. But obviously there are many preemie parents who have to deal with oxygen machines, delays, medicines and special needs when baby comes home. And even still there are parents who were so traumatized by a premature birth and NICU stay, that nothing regarding their baby really feels typical.")
            intent.putExtra("heading","Will he be like a 'typical' baby when he comes home? ")
            startActivity(intent)

        }
        button2.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email","I asked my husband what a common question was that he got about our son's premature birth, and he said far and away this was his most frequently asked. What happened? In my case I had Incompetent Cervix, in which the cervix dilates/shortens without contractions, so he said he had a fun time explaining to all his co-workers my condition by using his hands to form the shape of a cervix to demonstrate how it all works. There are a number of conditions that can cause premature birth, including premature rupture of membranes (water breaking), placental problems and preeclampsia, but many women don't have explanations for their premature birth.")
            intent.putExtra("heading","What happened?")
            startActivity(intent)

        }
        button3.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email","Ah! How do I answer this? My husband loved telling people what all the cords did. I did not care to explain. But generally the cords are to monitor oxygen saturation and heart rate, in addition to tubes which are typically feeding tubes and breathing tubes to assist with breathing, which can be in either the nose or mouth. The tubes and the wires can certainly be intimidating but they will come off eventually! Keep in mind that when others ask questions, they usually mean well. The majority of people are not versed in the NICU like you are. Answer their questions with patience and grace, in the hopes that they will begin to empathize and understand what you've been through.")
            intent.putExtra("heading","What are all the chords for?")
            startActivity(intent)

        }
        button7.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email","Kangaroo care, or skin-to-skin, is a way of cuddling and holding your baby close so that they feel the warmth of your skin and can hear your heartbeat. By holding your baby next to your skin, on your chest, with no other materials between you, your baby will feel secure, warm and close to you. This has been shown to have benefits such as lowering blood pressure and increasing oxygen saturation.It also helps parents develop a bond with their baby, and for mothers, initiates and continues their breast milk supply, which is very important when you have been separated when time is spent in the neonatal unit. Even very sick or premature babies benefit from kangaroo care, so do not be afraid to ask your nurse about it. Both men and women equally can do kangaroo care.")
            intent.putExtra("heading","What is kangaroo care and what are its benefits?")
            startActivity(intent)

        }
        button8.setOnClickListener{
            val intent = Intent(this,FAQmeaning::class.java)
            intent.putExtra("email","When separated from your baby you can still provide breast milk and plan to breastfeed. By starting to express breast milk as soon as six hours after birth you can provide that vital first milk (colostrum) which can either be fed to your baby through a nasogastric (NG) tube or frozen and given to them when they are ready for it. By continuing to express breast milk (ideally every three hours) you can maintain and increase your milk supply. When your baby is ready, you can initiate breastfeeding, or give breast milk in a bottle, alongside nasogastric (NG) feeding. If you are unable to supply your own milk then most neonatal units will have a donated breast milk supply, which is another way your baby can receive breast milk.Speak to your midwife and breastfeeding nurse, who can support you and give you information about breastfeeding including expression and storage of breast milk. Breast milk is the best nutrition for your baby, it is easiest for them to digest, and contains vital antibodies which protect against infections and growth factors which support your babyâ€™s growth and development.")
            intent.putExtra("heading","How can I maintain breast milk as the main source of nutrition for my baby?")
            startActivity(intent)

        }
        button9.setOnClickListener{
            val intent = Intent(this,FAQmeaning::class.java)
            intent.putExtra("email","Neonatal units have a range of provision for sick or premature babies, usually organized into three areas: intensive care (NICU), high dependency (HDU) and special care (SCBU).Caters for the most premature. Here most babies will be in closed incubators, possibly ventilated, to help them breathe and have a nasogastric (NG) tube to feed them. Other interventions might include monitors to record their heart rate and blood pressure. Despite all the high tech equipment it is still really important to interact with your baby as much as possible. Techniques such as comfort holding or kangaroo care (outlined below) can be used, so always ask your babyâ€™s nurse about how to interact with your baby.Caters for less sick babies. Some babies will be in closed incubators, whilst others might be in open cots. Your baby will be likely to spend time in HDU following time in NICU. They will still be closely monitored, possibly by getting oxygen through their nose and being fed through a nasogastric (NG) tube.SCBU caters for the least sick or less premature babies and most will be in open cots. Care might include a mattress which monitors your baby's breathing, they may be getting oxygen through their nose and being fed by nasogastric (NG) tube. If your baby has been through NICU and HDU, then this will be the next room you are in before being discharged home.")
            intent.putExtra("heading","What are the different levels of neonatal care?")
            startActivity(intent)

        }
        button11.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email"," Each case is different, and the answer can range from several hours to several weeks. Generally, the more prematurely a baby is born, or the more serious her illness, the longer her stay in a NICU. Her care team may be moved to a different level of NICU depending on her progress. Once a baby is showing that she can breathe on her own, regulate her body temperature, gain weight and be fed by breast or bottle, she should be ready to go home.")
            intent.putExtra("heading","How long will my baby be in the NICU?")
            startActivity(intent)

        }
        button13.setOnClickListener{
            val intent = Intent(this, FAQmeaning::class.java)
            intent.putExtra("email","It is important to note that while a preemie is the name given to any child born before 37 weeks gestation, there are subcategories within this general term. These include Low birth weight - babies who are born weighing less than 5 pounds, 8 ounces (2,500 grams). In contrast, the average newborn weighs about 8 pounds. Over 8 percent of all newborn babies in the United States have low birth weight. Moderately Premature - Babies born from the start of 32 to the end of 33 weeks gestation.Micropreemie - An infant who is born at less than 27 weeks gestation and weighs less than 1lb 12oz (800 grams).")
            intent.putExtra("heading","How much does a preemie weigh?")
            startActivity(intent)

        }
    }
}