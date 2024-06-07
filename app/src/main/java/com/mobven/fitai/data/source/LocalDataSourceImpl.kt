package com.mobven.fitai.data.source

import com.mobven.fitai.data.local.dao.UserDao
import com.mobven.fitai.data.model.entity.UserEntity
import com.mobven.fitai.domain.source.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : LocalDataSource {
    override fun insertUser(userEntity: UserEntity) {
        userDao.insertUser(userEntity)
    }

    override fun updateUserKey(userKey: String) {
        userDao.updateUserKey(userKey)
    }

    override fun insertUserKey(userKey: String) {
        userDao.insertUserKey(userKey)
    }

    override suspend fun getUserKey(): String {
        return userDao.getUserKey()
    }

    override suspend fun getUser(): UserEntity {
        return userDao.getUser()
    }

    override fun updateFirstEntrance() {
        userDao.updateFirstEntrance()
    }
}