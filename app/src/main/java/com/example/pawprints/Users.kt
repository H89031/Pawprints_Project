package com.example.pawprints

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val fullname: String,
    val username: String,
    val email: String,
    val bday: Date,
    val phonenum: String,
    val address: String,
    val password: String
    )