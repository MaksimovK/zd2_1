package com.example.cinemaapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.cinemaapp.databinding.ActivityMoviesScreenBinding
import com.squareup.picasso.Picasso

class MoviesScreen : Activity() {
    private lateinit var binding: ActivityMoviesScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieTitles = listOf("Witcher", "Jessica Jones", "Magicians")
        val key = "ceca9cb5"

        movieTitles.forEach { title ->
            val url = "https://www.omdbapi.com/?apikey=$key&t=$title"
            val queue = Volley.newRequestQueue(this)
            val request = JsonObjectRequest(Request.Method.GET, url, null,
                { response ->
                    val posterUrl = response.getString("Poster")
                    val movieTitle = response.getString("Title")
                    when (title) {
                        "Witcher" -> {
                            Picasso.get().load(posterUrl).into(binding.rectangleImageView1)
                            binding.ImageText1.text = movieTitle
                        }
                        "Jessica Jones" -> {
                            Picasso.get().load(posterUrl).into(binding.rectangleImageView2)
                            binding.ImageText2.text = movieTitle
                        }
                        "Magicians" -> {
                            Picasso.get().load(posterUrl).into(binding.rectangleImageView3)
                            binding.ImageText3.text = movieTitle
                        }
                    }
                },
                { error ->
                    Log.d("MoviesScreen", "Volley error: $error")
                }
            )
            queue.add(request)
        }
    }
}
