package com.mobven.fitai.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mobven.fitai.data.local.dao.UserDao
import com.mobven.fitai.data.model.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class FitAIDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}