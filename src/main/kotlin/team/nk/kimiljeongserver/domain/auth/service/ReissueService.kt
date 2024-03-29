package team.nk.kimiljeongserver.domain.auth.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.auth.domain.repository.RefreshTokenRepository
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.global.exception.RefreshTokenNotFoundException
import team.nk.kimiljeongserver.global.exception.UnexpectedTokenException
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenParser
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenProvider
import team.nk.kimiljeongserver.global.security.jwt.properties.JwtProperties

@Service
class ReissueService(
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtTokenParser: JwtTokenParser,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtProperties: JwtProperties
) {

    @Transactional
    fun execute(refreshToken: String): TokenResponse {
        if (!jwtTokenParser.validateToken(refreshToken)) throw UnexpectedTokenException.EXCEPTION

        val usedToken =
            refreshTokenRepository.findByToken(refreshToken) ?: throw RefreshTokenNotFoundException.EXCEPTION

        usedToken.timeToLive = jwtProperties.refreshExp

        val accessToken = jwtTokenProvider.generateAccessToken(usedToken.email)
        val newRefreshToken = jwtTokenProvider.generateRefreshToken(usedToken.email)
        val expiredAt = jwtTokenParser.getExpiredTime()

        return TokenResponse(
            accessToken = accessToken,
            refreshToken = newRefreshToken,
            expiredAt = expiredAt
        )
    }
}
