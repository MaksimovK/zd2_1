package com.example.cinemaapp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.cinemaapp.databinding.ActivityLaunchScreenBinding

@SuppressLint("CustomSplashScreen")
class LaunchScreenActivity : Activity() {
    private lateinit var binding: ActivityLaunchScreenBinding
    private val splashDelay: Long = 2000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLaunchScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setContentView(R.layout.activity_launch_screen)
        Handler().postDelayed({
            val intent = Intent(this@LaunchScreenActivity, SignInScreen::class.java)
            startActivity(intent)
            finish()
        }, splashDelay)
    }
}