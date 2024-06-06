package com.mobven.fitai.domain.usecase

import com.mobven.fitai.data.dto.SignUpDto
import com.mobven.fitai.domain.repository.FitAIRepository
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val fitAIRepository: FitAIRepository
) {
    operator fun invoke(signUpDto: SignUpDto) {
        fitAIRepository.registerUser(signUpDto)
    }
}