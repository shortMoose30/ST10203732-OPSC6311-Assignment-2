package com.example.olemsaprojectsroomdb.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.olemsaprojectsroomdb.data.User


@Dao
abstract class UserDao {
    @Insert
    abstract suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    abstract suspend fun login(username: String, password: String): User?

    @Query("SELECT * FROM users WHERE username = :username")
    abstract suspend fun getUserByUsername(username: String): User?
}


