package com.example.cinemaapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.cinemaapp.databinding.ActivitySignInScreenBinding

class SignInScreen : Activity() {

    private lateinit var binding: ActivitySignInScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val savedEmail = sharedPreferences.getString("emailKey", null)
        val savedPassword = sharedPreferences.getString("passwordKey", null)

        if (savedEmail != null && savedPassword != null) {
            binding.emailEditText.setText(savedEmail)
            binding.passwordEditText.setText(savedPassword)
        }

        binding.signInButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT).show()
            } else if (!isEmailValid(email)) {
                Toast.makeText(this, "Неверный ввод почты.", Toast.LENGTH_SHORT).show()
            } else {
                // Проверка или сохранение данных
                if (savedEmail != null && savedPassword != null) {
                    // Проверка данных
                    if (email == savedEmail && password == savedPassword) {
                        navigateToMainScreen()
                    } else {
                        Toast.makeText(this, "Неверные учетные данные", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Сохранение новых данных
                    val editor = sharedPreferences.edit()
                    editor.putString("emailKey", email)
                    editor.putString("passwordKey", password)
                    editor.apply()

                    navigateToMainScreen()
                }
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun navigateToMainScreen() {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }
}
