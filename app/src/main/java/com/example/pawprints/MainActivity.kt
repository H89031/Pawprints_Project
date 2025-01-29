package com.example.pawprints

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch
import java.sql.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

////// TEST DB
//        lifecycleScope.launch {
//
//            val db = AppDatabase.getDatabase(applicationContext)
//            val userDao = db.usersDao()
//            val nuke: Unit = userDao.nukeTable()
////            val users: List<Users> = userDao.getAllUsers()
//
////            val Mikael: Unit = userDao.insertUser(
////                Users(0,"jack","handsome","www2","10/20/30","000",
////                    "sadasda","11111")
////            )
//        }

//        val db = Room.databaseBuilder(
//            applicationContext,
//            AppDatabase::class.java, "paw_db"
//        ).allowMainThreadQueries().build()
//
        //val nuke: Unit = userDao.nukeTable()

//        val Mikael: Unit = userDao.insertUser(
//            Users(0,"jack","handsome","www","10/20/30","000",
//                "sadasda","11111")
//        )
//        val s: Unit = userDao.insertUser(
//            Users(0,"jack","handsome","www","10/20/30","000",
//                "sadasda","11111")
//        )
//        val Mikdael: Unit = userDao.insertUser(
//            Users(0,"jack","handsome","www","10/20/30","000",
//                "sadasda","11111")
//        )

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}