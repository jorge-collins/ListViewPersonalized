package com.example.listviewpersonalized

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviewpersonalized.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val imageId = intArrayOf(
            R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.a,R.drawable.b,R.drawable.c
        )

        val name = arrayOf(
            "alma","berenice","carolina","alexa","beto","carlos"
        )

        val lastMessage = arrayOf(
            "lma1","lmb2","lmc3","lma4","lmb5","lmc6"
        )

        val lastMsgTime = arrayOf(
            "1:00","2:00","13:00","4:00","15:00","6:00"
        )

        val phoneNo = arrayOf(
            "543452521","543452522","543452523","543452524","543452525","543452526"
        )

        val country = arrayOf(
            "US","MX","CL","AR","BR","JP"
        )


        userArrayList = ArrayList()

        for (i in name.indices) {
            val user = User(name[i], lastMessage[i], lastMsgTime[i], phoneNo[i], country[i], imageId[i])
            userArrayList.add(user)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val phone = phoneNo[position]
            val country = country[position]
            val imageId = imageId[position]

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name", name)
            i.putExtra("phone", phone)
            i.putExtra("country", country)
            i.putExtra("imageId", imageId)

            startActivity(i)
        }
    }
}