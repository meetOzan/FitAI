package com.mobven.fitai.data.di

import android.content.Context
import androidx.room.Room
import com.mobven.fitai.common.Constants.DATABASE_NAME
import com.mobven.fitai.data.local.database.FitAIDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object LocalModule {

    @[Provides Singleton]
    fun provideDatabase(@ApplicationContext context: Context) : FitAIDatabase {
        return Room.databaseBuilder(
            context,
            FitAIDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries().fallbackToDestructiveMigrationFrom().build()
    }

    @[Provides Singleton]
    fun provideUserDao(database: FitAIDatabase) = database.userDao()

}