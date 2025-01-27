package com.example.pawprints

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Users(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo val fullname: String,
    @ColumnInfo val username: String,
    @ColumnInfo val email: String,
    @ColumnInfo val bday: String,
    @ColumnInfo val phonenum: String,
    @ColumnInfo val address: String,
    @ColumnInfo val password: String
    )