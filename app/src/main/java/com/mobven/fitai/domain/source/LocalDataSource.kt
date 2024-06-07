package com.mobven.fitai.domain.source

import com.mobven.fitai.data.model.entity.UserEntity

interface LocalDataSource {

    fun insertUser(userEntity: UserEntity)

    fun updateUserKey(userKey: String)

    fun insertUserKey(userKey: String)

    suspend fun getUserKey(): String

    suspend fun getUser(): UserEntity

}