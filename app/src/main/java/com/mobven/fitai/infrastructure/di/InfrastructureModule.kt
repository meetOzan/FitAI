package com.mobven.fitai.infrastructure.di

import android.content.Context
import com.mobven.fitai.infrastructure.string_resource.StringResourceProvider
import com.mobven.fitai.infrastructure.string_resource.StringResourceProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
@[Module InstallIn(ViewModelComponent::class)]
object InfrastructureModule {

    @Provides
    fun provideStringResourceProvider(
        @ApplicationContext context: Context
    ): StringResourceProvider = StringResourceProviderImpl(context = context)

}