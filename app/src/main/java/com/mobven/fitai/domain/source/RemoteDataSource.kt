package com.mobven.fitai.domain.source

fun interface RemoteDataSource {

    suspend fun getExercises()

}