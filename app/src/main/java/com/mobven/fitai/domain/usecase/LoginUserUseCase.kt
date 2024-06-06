package com.mobven.fitai.domain.usecase

import com.mobven.fitai.data.dto.SignInDto
import com.mobven.fitai.domain.repository.FitAIRepository
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val fitAIRepository: FitAIRepository
){
    operator fun invoke(signInDto: SignInDto) {
        fitAIRepository.loginUser(signInDto)
    }
}