package com.mobven.fitai.domain.usecase

import com.mobven.fitai.data.dto.FirstLoginDto
import com.mobven.fitai.domain.repository.FitAIRepository
import javax.inject.Inject

class SaveFirstLoginUseCase @Inject constructor(
    private val repository: FitAIRepository
) {
    operator fun invoke(authToken: String, saveFirstLoginDto: FirstLoginDto) {
        repository.saveFirstLogin(authToken, saveFirstLoginDto)
    }
}