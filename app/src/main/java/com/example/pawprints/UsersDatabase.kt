package com.example.pawprints

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import kotlin.concurrent.Volatile


@Database(entities = [Users::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usersDao(): UsersDao

}