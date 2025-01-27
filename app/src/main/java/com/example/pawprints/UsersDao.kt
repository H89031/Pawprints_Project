package com.example.pawprints

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: Users)

    @Delete
    suspend fun delete(user: Users)

    @Query("SELECT * FROM Users WHERE username = :userId OR email = :userId")
    fun getUserByLoginId(userId: String?): Users?

    @Query("SELECT * FROM Users")
    suspend fun getAllUsers(): List<Users>


}