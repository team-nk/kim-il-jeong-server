package com.example.kimiljeongserver.global.security.jwt

import com.example.kimiljeongdomain.user.spi.JwtTokenGeneratePort
import com.example.kimiljeongserver.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties
) : JwtTokenGeneratePort {

    override fun generateAccessToken(accountId: String): String {
        return generateToken(accountId, jwtProperties.accessExp, JwtProperties.ACCESS_VALUE)
    }

    override fun generateRefreshToken(accountId: String): String {
        return generateToken(accountId, jwtProperties.refreshExp, JwtProperties.REFRESH_VALUE)
    }

    private fun generateToken(accountId: String, exp: Int, type: String): String {
        return "Bearer " + Jwts.builder()
            .setSubject(accountId)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS512, jwtProperties.secretKey)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setHeaderParam("typ", type)
            .compact()
    }
}