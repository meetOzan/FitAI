package com.mobven.fitai.domain.repository

import com.mobven.fitai.common.ResponseState
import com.mobven.fitai.data.model.dto.FirstLoginDto
import com.mobven.fitai.data.model.dto.SignInDto
import com.mobven.fitai.data.model.dto.SignUpDto
import com.mobven.fitai.data.model.dto.WorkoutDetailsDto
import com.mobven.fitai.data.model.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface FitAIRepository {

    fun registerUser(registerUser: SignUpDto) : Flow<ResponseState<String>>

    fun loginUser(loginUser: SignInDto) : Flow<ResponseState<String>>

    fun saveFirstLogin(authToken: String, firstLoginDto: FirstLoginDto) : Flow<ResponseState<String>>

    fun saveWorkoutDetails(authToken: String, workoutDetailsDto: WorkoutDetailsDto) : Flow<ResponseState<String>>

    // Local
    fun getUser(): Flow<ResponseState<UserEntity>>

    fun getUserKey(): Flow<ResponseState<String>>

    fun insertUser(userEntity: UserEntity)

    fun insertUserKey(userKey: String)

    fun updateUserKey(userKey: String)

}