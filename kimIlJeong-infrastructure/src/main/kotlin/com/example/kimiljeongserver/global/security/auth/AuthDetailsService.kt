package com.example.kimiljeongserver.global.security.auth

import com.example.kimiljeongserver.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userFacade: UserFacade
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userFacade.findUserByAccountId(username)
        return AuthDetails(user)
    }
}