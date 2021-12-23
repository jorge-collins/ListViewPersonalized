package com.example.listviewpersonalized

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listviewpersonalized.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra("name")
        var phone = intent.getStringExtra("phone")
        var country = intent.getStringExtra("country")
        var imageId = intent.getIntExtra("imageId", R.drawable.a)

        binding.nameProfile.text = name
        binding.phoneProfile.text = phone
        binding.countryProfile.text = country
        binding.profileImage.setImageResource(imageId)


        title = "User details"
    }
}