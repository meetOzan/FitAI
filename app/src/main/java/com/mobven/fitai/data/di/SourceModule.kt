package com.mobven.fitai.data.di

import com.mobven.fitai.data.local.dao.UserDao
import com.mobven.fitai.data.remote.FitAIService
import com.mobven.fitai.data.source.LocalDataSourceImpl
import com.mobven.fitai.data.source.RemoteDataSourceImpl
import com.mobven.fitai.domain.source.LocalDataSource
import com.mobven.fitai.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
object SourceModule {

    @[Provides Singleton]
    fun provideRemoteDataSource(
        fitAIService: FitAIService
    ): RemoteDataSource = RemoteDataSourceImpl(fitAIService)

    @[Provides Singleton]
    fun provideLocalDataSource(
        userDao: UserDao
    ): LocalDataSource = LocalDataSourceImpl(userDao)

}