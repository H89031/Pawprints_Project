package com.example.pawprints

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(vararg user: Users)

    @Query("DELETE FROM Users")
    suspend fun nukeTable()

    @Delete
    suspend fun delete(user: Users)

    @Query("SELECT * FROM Users WHERE username = :userId OR email = :userId OR fullname = :userId")
    suspend fun getUserByLoginId(userId: String?): Users?

    @Query("SELECT * FROM Users WHERE username LIKE :uname AND password LIKE :password")
    fun readLoginData(uname: String?, password: String?):Users

    @Query("select * from Users where id Like :id")
    fun getUserDataDetails(id:Long):Users

    @Query("SELECT EXISTS(SELECT 1 FROM Users WHERE (username LIKE :inpName OR email LIKE :inpName) AND password LIKE :inpPass)")
    suspend fun getLogging(inpName: String?, inpPass: String?): Boolean

    @Query("SELECT * FROM Users")
    suspend fun getAllUsers(): List<Users>


}