package com.example.cinemaapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.cinemaapp.databinding.ActivityMainScreenBinding

class MainScreen : Activity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val discussionsImageView: ImageView = findViewById(R.id.discussionsImageView)
        val setsImageView: ImageView = findViewById(R.id.setsImageView)
        val favouritesImageView: ImageView = findViewById(R.id.favouritesImageView)

        discussionsImageView.setOnClickListener {
            val intent = Intent(this, ChatListScreen::class.java)
            startActivity(intent)
        }

        setsImageView.setOnClickListener {
            val intent = Intent(this, MoviesScreen::class.java)
            startActivity(intent)
        }

        favouritesImageView.setOnClickListener {
            Toast.makeText(this, "♥", Toast.LENGTH_SHORT).show()
        }
    }
}