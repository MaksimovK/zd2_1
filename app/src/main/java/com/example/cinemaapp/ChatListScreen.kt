package com.example.cinemaapp

import android.app.Activity
import android.os.Bundle
import com.example.cinemaapp.databinding.ActivityChatListScreenBinding

class ChatListScreen : Activity() {

private lateinit var binding: ActivityChatListScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityChatListScreenBinding.inflate(layoutInflater)
     setContentView(binding.root)

    }
}