package com.example.kimiljeongserver.global.security.auth

import com.example.kimiljeongserver.domain.user.domain.UserEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: UserEntity
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf()

    override fun getPassword(): String? = null

    override fun getUsername(): String = user.accountId

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true

}