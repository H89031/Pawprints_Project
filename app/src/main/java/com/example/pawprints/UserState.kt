package com.example.pawprints

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

object loggs {
    val eventArray : ArrayList<UserState> = arrayListOf()
}

data class UserState(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo val fullname: String,
    @ColumnInfo val username: String,
    @ColumnInfo val email: String,
    @ColumnInfo val bday: java.sql.Date,
    @ColumnInfo val phonenum: String,
    @ColumnInfo val address: String,
    @ColumnInfo val password: String
)