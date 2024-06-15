package com.mobven.fitai.data.di

import com.mobven.fitai.data.repository.FitAIRepositoryImpl
import com.mobven.fitai.domain.repository.FitAIRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
abstract class RepositoryModule {

    @[Binds Singleton]
    abstract fun bindFitAIRepository(fitAIRepositoryImpl: FitAIRepositoryImpl) : FitAIRepository

}