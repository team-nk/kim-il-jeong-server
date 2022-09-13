package com.example.kimiljeongserver.domain.user.facade

import com.example.kimiljeongserver.domain.user.domain.UserEntity
import com.example.kimiljeongserver.domain.user.domain.repositroy.UserRepository
import com.example.kimiljeongserver.domain.user.exceptions.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserFacadeImpl(
    private val userRepository: UserRepository
): UserFacade {
    override fun findUserByAccountId(accountId: String): UserEntity {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION
    }
}
