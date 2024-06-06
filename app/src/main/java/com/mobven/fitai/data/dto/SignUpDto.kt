package com.mobven.fitai.data.dto

data class SignUpDto(
    val email: String,
    val firstName: String,
    val lastName: String,
    val password: String,
    val passwordConfirm: String,
    val userName: String
)