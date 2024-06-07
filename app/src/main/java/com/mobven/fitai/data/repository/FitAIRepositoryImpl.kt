package com.mobven.fitai.data.repository

import com.mobven.fitai.common.ResponseState
import com.mobven.fitai.data.model.dto.FirstLoginDto
import com.mobven.fitai.data.model.dto.SignInDto
import com.mobven.fitai.data.model.dto.SignUpDto
import com.mobven.fitai.data.model.dto.WorkoutDetailsDto
import com.mobven.fitai.data.model.entity.UserEntity
import com.mobven.fitai.domain.repository.FitAIRepository
import com.mobven.fitai.domain.source.LocalDataSource
import com.mobven.fitai.domain.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FitAIRepositoryImpl @Inject constructor(
    private val provideRemoteSource: RemoteDataSource,
    private val provideLocalSource: LocalDataSource
) : FitAIRepository {

    override fun registerUser(registerUser: SignUpDto): Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = provideRemoteSource.registerUser(registerUser)
            insertUserKey(response)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    override fun loginUser(loginUser: SignInDto): Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = provideRemoteSource.loginUser(loginUser)
            insertUserKey(response)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    override fun saveFirstLogin(
        authToken: String,
        firstLoginDto: FirstLoginDto
    ): Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = provideRemoteSource.saveFirstLogin(authToken, firstLoginDto)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }

    }

    override fun saveWorkoutDetails(
        authToken: String,
        workoutDetailsDto: WorkoutDetailsDto
    ): Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = provideRemoteSource.saveWorkoutDetails(authToken, workoutDetailsDto)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    override fun getUser(): Flow<ResponseState<UserEntity>> {
        return flow {
            emit(ResponseState.Loading)
            val response = provideLocalSource.getUser()
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    override fun getUserKey(): Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = provideLocalSource.getUserKey()
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    override fun insertUser(userEntity: UserEntity) {
        provideLocalSource.insertUser(userEntity)
    }

    override fun insertUserKey(userKey: String) {
        provideLocalSource.insertUserKey(userKey)
    }

    override fun updateUserKey(userKey: String) {
        provideLocalSource.updateUserKey(userKey)
    }

}