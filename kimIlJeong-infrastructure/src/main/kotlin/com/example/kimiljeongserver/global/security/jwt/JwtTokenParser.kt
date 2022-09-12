package com.example.kimiljeongserver.global.security.jwt

import com.example.kimiljeongserver.global.exceptions.*
import com.example.kimiljeongserver.global.security.auth.AuthDetailsService
import com.example.kimiljeongserver.global.security.jwt.properties.JwtProperties
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenParser(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {
    fun authenticateUser(token: String): Authentication {
        val claims = getClaims(token)
        val id = claims.subject
        val authDetails = authDetailsService.loadUserByUsername(id.toString())
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    fun getTokenFromHeader(httpServletRequest: HttpServletRequest): String? =
        httpServletRequest.getHeader(JwtProperties.TOKEN_HEADER)

    fun parseToken(token: String): String {
        if (token.startsWith(JwtProperties.TOKEN_PREFIX)) {
            return token.replace(JwtProperties.TOKEN_PREFIX, "")
        }
        throw JwtValidateFailedException.EXCEPTION
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJwt(token)
                .body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw JwtExpiredException.EXCEPTION
                is MalformedJwtException -> throw JwtMalformedException.EXCEPTION
                is SignatureException -> throw JwtSignatureException.EXCEPTION
                is UnsupportedJwtException -> throw JwtUnsupportedException.EXCEPTION
                else -> throw JwtUnexpectedException.EXCEPTION
            }
        }
    }
}