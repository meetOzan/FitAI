package com.mobven.fitai.domain.source

import com.mobven.fitai.data.dto.FirstLoginDto
import com.mobven.fitai.data.dto.SignInDto
import com.mobven.fitai.data.dto.SignUpDto
import com.mobven.fitai.data.dto.WorkoutDetailsDto

interface RemoteDataSource {

    suspend fun registerUser(registerUser: SignUpDto): String

    suspend fun loginUser(loginUser: SignInDto): String

    suspend fun saveFirstLogin(authToken: String, firstLoginDto: FirstLoginDto): String

    suspend fun saveWorkoutDetails(authToken: String, workoutDetailsDto: WorkoutDetailsDto): String

}