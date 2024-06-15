package com.mobven.fitai.data.source

import com.mobven.fitai.data.model.dto.FirstLoginDto
import com.mobven.fitai.data.model.dto.SignInDto
import com.mobven.fitai.data.model.dto.SignUpDto
import com.mobven.fitai.data.model.dto.WorkoutDetailsDto
import com.mobven.fitai.data.remote.FitAIService
import com.mobven.fitai.domain.source.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val fitAIService: FitAIService
) : RemoteDataSource {

    override suspend fun registerUser(registerUser: SignUpDto): String {
        return fitAIService.registerUser(registerUser)
    }

    override suspend fun loginUser(loginUser: SignInDto): String {
        return fitAIService.loginUser(loginUser)
    }

    override suspend fun saveFirstLogin(authToken: String, firstLoginDto: FirstLoginDto) : String {
        return fitAIService.saveFirstLogin(authToken ,firstLoginDto)
    }

    override suspend fun saveWorkoutDetails(authToken: String, workoutDetailsDto: WorkoutDetailsDto) : String {
        return fitAIService.saveWorkoutDetails(authToken ,workoutDetailsDto)
    }

}