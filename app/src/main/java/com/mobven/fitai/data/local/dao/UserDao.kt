package com.mobven.fitai.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.mobven.fitai.data.model.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT user_id FROM user_entity")
    fun getUserKey(): String

    @Query("SELECT * FROM user_entity")
    fun getUser(): UserEntity

    @Upsert
    fun insertUser(user: UserEntity)

    @Query("INSERT INTO user_entity (user_id) VALUES (:userId)")
    fun insertUserKey(userId: String)

    @Query("UPDATE user_entity SET user_id = :userId")
    fun updateUserKey(userId: String)
}