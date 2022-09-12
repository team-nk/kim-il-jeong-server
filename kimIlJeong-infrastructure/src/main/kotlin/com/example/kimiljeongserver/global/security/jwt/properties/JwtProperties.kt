package com.example.kimiljeongserver.global.security.jwt.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "jwt")
@ConstructorBinding
class JwtProperties(
    val secretKey: String,
    val accessExp: Int,
    val refreshExp: Int
) {
    companion object {
        const val TOKEN_PREFIX = "Bearer "
        const val TOKEN_HEADER = "Authorization"
        const val ACCESS_VALUE = "access"
        const val REFRESH_VALUE = "refresh"
    }
}