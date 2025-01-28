package com.example.pawprints

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date

@Entity(indices = [Index(value = ["email"], unique = true)])

data class Users(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo val fullname: String,
    @ColumnInfo val username: String,
    @ColumnInfo val email: String,
    @ColumnInfo val bday: java.sql.Date,
    @ColumnInfo val phonenum: String,
    @ColumnInfo val address: String,
    @ColumnInfo val password: String
    )

