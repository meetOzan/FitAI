package com.mobven.fitai.data.source

import com.mobven.fitai.data.remote.FitAIService
import com.mobven.fitai.domain.source.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val fitAIService: FitAIService
) : RemoteDataSource {

    // TODO: Remote data source methods will be implemented here
    override suspend fun getExercises() {
        fitAIService.getExercises()
    }

}