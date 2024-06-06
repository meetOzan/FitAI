package com.mobven.fitai.domain.usecase

import com.mobven.fitai.data.dto.FirstLoginDto
import com.mobven.fitai.data.dto.WorkoutDetailsDto
import com.mobven.fitai.domain.repository.FitAIRepository
import javax.inject.Inject

class SaveWorkoutDetailsUseCase @Inject constructor(
    private val repository: FitAIRepository
) {
    operator fun invoke(authToken: String, saveWorkoutDetailsDto: WorkoutDetailsDto) {
        repository.saveWorkoutDetails(authToken, saveWorkoutDetailsDto)
    }
}