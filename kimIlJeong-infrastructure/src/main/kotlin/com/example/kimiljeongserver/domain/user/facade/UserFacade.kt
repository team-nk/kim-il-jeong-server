package com.example.kimiljeongserver.domain.user.facade

import com.example.kimiljeongserver.domain.user.domain.UserEntity

sealed interface UserFacade {
    fun findUserByAccountId(accountId: String): UserEntity
}