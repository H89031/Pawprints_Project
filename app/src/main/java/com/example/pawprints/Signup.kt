package com.example.pawprints

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.sql.Date


class Signup() : AppCompatActivity() {


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        val loggingIn: Button = findViewById(R.id.signedup)

        loggingIn.setOnClickListener {
            ///FIX THIS
            lifecycleScope.launch {
                val db = AppDatabase.getDatabase(applicationContext)
                val userDao = db.usersDao()
                val User: Unit = userDao.insertUser(
                    Users(0, getString(R.id.name),getText(R.id.username).toString(),
                        getString(R.id.email), Date(0-0-0),getText(R.id.phone).toString(),
                        getText(R.id.city).toString(),getText(R.id.password).toString())
                )
                val users: List<Users> = userDao.getAllUsers()
            }

            finish()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}