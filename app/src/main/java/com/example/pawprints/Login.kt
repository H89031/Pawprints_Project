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
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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

    @OptIn(DelicateCoroutinesApi::class)
    fun LoggingIn(view: View) {
        val username = findViewById<EditText>(R.id.input_name)
        val password = findViewById<EditText>(R.id.input_password)
        val intent = Intent(this@Login, Navigation::class.java)

        if (username.text.isNotEmpty() && password.text.isNotEmpty()){
            GlobalScope.launch{
                val db = AppDatabase.getDatabase(applicationContext)
                val userDao = db.usersDao()
                try {
                    val Exists: Boolean = userDao.getLogging(username.text.toString(), password.text.toString())
                    // Handle the result
                    if (Exists) {
                        startActivity(intent)
                    } else {
                        username.setError("Incorrect Username or Password")
                        password.setError("Incorrect Username or Password")
                    }
                } catch (e: Throwable) {
                    // Handle any exceptions
                    println("Error: ${e.message}")
                }
            }

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

