package com.mobven.fitai.domain.repository

import com.mobven.fitai.common.ResponseState
import com.mobven.fitai.data.dto.FirstLoginDto
import com.mobven.fitai.data.dto.SignInDto
import com.mobven.fitai.data.dto.SignUpDto
import com.mobven.fitai.data.dto.WorkoutDetailsDto
import kotlinx.coroutines.flow.Flow

interface FitAIRepository {

    fun registerUser(registerUser: SignUpDto) : Flow<ResponseState<String>>

    fun loginUser(loginUser: SignInDto) : Flow<ResponseState<String>>

    fun saveFirstLogin(authToken: String, firstLoginDto: FirstLoginDto) : Flow<ResponseState<String>>

    fun saveWorkoutDetails(authToken: String, workoutDetailsDto: WorkoutDetailsDto) : Flow<ResponseState<String>>

}