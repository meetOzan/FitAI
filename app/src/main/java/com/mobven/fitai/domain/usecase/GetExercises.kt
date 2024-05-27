package com.mobven.fitai.domain.usecase

import com.mobven.fitai.domain.repository.FitAIRepository
import javax.inject.Inject

class GetExercises @Inject constructor(
    private val fitAIRepository: FitAIRepository
) {

    suspend operator fun invoke() = fitAIRepository.getExercises()

}