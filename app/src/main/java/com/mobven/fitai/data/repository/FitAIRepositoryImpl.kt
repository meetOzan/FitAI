package com.mobven.fitai.data.repository

import com.mobven.fitai.common.ResponseState
import com.mobven.fitai.data.dto.FirstLoginDto
import com.mobven.fitai.data.dto.SignInDto
import com.mobven.fitai.data.dto.SignUpDto
import com.mobven.fitai.data.dto.WorkoutDetailsDto
import com.mobven.fitai.data.source.RemoteDataSourceImpl
import com.mobven.fitai.domain.repository.FitAIRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FitAIRepositoryImpl @Inject constructor(
    private val remoteDataSourceImpl: RemoteDataSourceImpl
) : FitAIRepository {

    override fun registerUser(registerUser: SignUpDto): Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = remoteDataSourceImpl.registerUser(registerUser)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    override fun loginUser(loginUser: SignInDto): Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = remoteDataSourceImpl.loginUser(loginUser)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

    override fun saveFirstLogin(authToken: String, firstLoginDto: FirstLoginDto) : Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = remoteDataSourceImpl.saveFirstLogin(authToken, firstLoginDto)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }

    }

    override fun saveWorkoutDetails(authToken: String, workoutDetailsDto: WorkoutDetailsDto) : Flow<ResponseState<String>> {
        return flow {
            emit(ResponseState.Loading)
            val response = remoteDataSourceImpl.saveWorkoutDetails(authToken, workoutDetailsDto)
            emit(ResponseState.Success(response))
        }.catch {
            emit(ResponseState.Error(it.message.orEmpty()))
        }
    }

}