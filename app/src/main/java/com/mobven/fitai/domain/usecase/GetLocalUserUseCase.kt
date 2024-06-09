package com.mobven.fitai.domain.usecase

import com.mobven.fitai.common.ResponseState
import com.mobven.fitai.data.model.entity.UserEntity
import com.mobven.fitai.domain.repository.FitAIRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocalUserUseCase @Inject constructor(
    private val repository: FitAIRepository
) {
    operator fun invoke() : Flow<ResponseState<UserEntity>> {
        return repository.getUser()
    }
}