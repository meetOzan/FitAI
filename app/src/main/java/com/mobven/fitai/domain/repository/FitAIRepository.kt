package com.mobven.fitai.domain.repository

import com.mobven.fitai.common.ResponseState

fun interface FitAIRepository {

    suspend fun getExercises()

}