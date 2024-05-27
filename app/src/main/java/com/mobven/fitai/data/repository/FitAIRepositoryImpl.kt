package com.mobven.fitai.data.repository

import com.mobven.fitai.common.ResponseState
import com.mobven.fitai.data.source.RemoteDataSourceImpl
import com.mobven.fitai.domain.repository.FitAIRepository
import javax.inject.Inject

class FitAIRepositoryImpl @Inject constructor(
    private val remoteDataSourceImpl: RemoteDataSourceImpl
) : FitAIRepository {

    // TODO: Repository methods will be implemented here
    override suspend fun getExercises() {
        remoteDataSourceImpl.getExercises()
    }

}