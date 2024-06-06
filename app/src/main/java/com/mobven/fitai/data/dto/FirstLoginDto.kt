package com.mobven.fitai.data.dto

data class FirstLoginDto(
    val dateOfBirth: String,
    val firstWeight: Int,
    val gender: String,
    val goals: String,
    val height: Int,
    val targetWeight: Int
)