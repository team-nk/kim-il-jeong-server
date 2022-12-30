package team.nk.kimiljeongserver.global.security.jwt

import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import team.nk.kimiljeongserver.global.exception.ExpiredTokenException
import team.nk.kimiljeongserver.global.exception.JwtValidateException
import team.nk.kimiljeongserver.global.exception.SignatureTokenException
import team.nk.kimiljeongserver.global.exception.UnexpectedTokenException
import team.nk.kimiljeongserver.global.security.jwt.properties.JwtProperties
import team.nk.kimiljeongserver.global.security.principle.AuthDetailsService
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenParser(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {
    companion object {
        private const val JWT_HEADER = "Authorization"
        private const val JWT_PREFIX = "Bearer "
    }

    fun getAuthentication(token: String?): Authentication? {
        return token?.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))

            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    fun resolveToken(httpServletRequest: HttpServletRequest): String? {
        val bearerToken: String? = httpServletRequest.getHeader(JWT_HEADER)
        return parseToken(bearerToken)
    }

    fun parseToken(token: String?): String? {
        return if (token != null && token.startsWith(JWT_PREFIX)) {
            return token.replace(JWT_PREFIX, "")
        } else null
    }

    fun validateToken(token: String): Boolean {
        return parseTokenBody(token)
            .expiration.after(Date());
    }

    private fun getTokenSubject(subject: String): String {
        return parseTokenBody(subject).subject
    }

    private fun parseTokenBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                is SignatureException -> throw SignatureTokenException.EXCEPTION
                is MalformedJwtException -> throw JwtValidateException.EXCEPTION
                else -> throw UnexpectedTokenException.EXCEPTION
            }
        }
    }
}