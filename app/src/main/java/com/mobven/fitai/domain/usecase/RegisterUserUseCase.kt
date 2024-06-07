package com.mobven.fitai.domain.usecase

import com.mobven.fitai.common.ResponseState
import com.mobven.fitai.data.model.dto.SignUpDto
import com.mobven.fitai.domain.repository.FitAIRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val fitAIRepository: FitAIRepository
) {
    operator fun invoke(signUpDto: SignUpDto) : Flow<ResponseState<String>> {
        return fitAIRepository.registerUser(signUpDto)
    }
}