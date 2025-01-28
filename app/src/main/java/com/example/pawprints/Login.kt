package com.example.pawprints

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room


class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun signupclick(view: View) {
        val intent = Intent(this@Login, Signup::class.java)
        startActivity(intent)
    }

    fun LoggingIn(view: View) {
        val username = findViewById<EditText>(R.id.input_name)
        val password = findViewById<EditText>(R.id.input_password)
        val intent = Intent(this@Login, Navigation::class.java)

        if (username.text.isNotEmpty() && password.text.isNotEmpty()){
            startActivity(intent)
        }
        else{
            if(username.text.isEmpty()){
                username.setError("Input your Username")
            }
            if(password.text.isEmpty()){
                password.setError("Input your Password")
            }
        }


    }
}

