package team.nk.kimiljeongserver.global.security.jwt

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import team.nk.kimiljeongserver.domain.auth.domain.RefreshToken
import team.nk.kimiljeongserver.domain.auth.domain.repository.RefreshTokenRepository
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.global.security.jwt.properties.JwtProperties
import java.util.*

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    companion object {
        private const val ACCESS_KEY = "access"
        private const val REFRESH_KEY = "refresh"
    }

    fun getToken(email: String): TokenResponse {
        val accessToken: String = generateToken(email, jwtProperties.accessExp, ACCESS_KEY)
        val refreshToken: String = generateRefreshToken(email)

        return TokenResponse(accessToken = accessToken, refreshToken = refreshToken)
    }

    fun generateAccessToken(email: String): String {
        return generateToken(email, jwtProperties.accessExp, ACCESS_KEY)
    }

    fun generateRefreshToken(email: String): String {
        val newRefreshToken: String = generateToken(email, jwtProperties.refreshExp, REFRESH_KEY)
        refreshTokenRepository.save(
            RefreshToken(
                email = email,
                token = newRefreshToken,
                timeToLive = jwtProperties.refreshExp
            )
        )
        return newRefreshToken
    }

    private fun generateToken(email: String, expiration: Long, type: String): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(email)
            .setHeaderParam("type", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .compact()
    }
}