package com.mobven.fitai.data.remote

import retrofit2.http.GET

fun interface FitAIService {

    // TODO: Define API endpoints here

    // For now, a temporarily used function
    @GET("api/v1/exercises")
    suspend fun getExercises(): List<String>

}