package team.nk.kimiljeongserver.domain.user.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.exception.PasswordMissMatchedException
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.LoginUserRequest
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenParser
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenProvider

@Service
class LoginUserService(
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtTokenParser: JwtTokenParser
) {

    @Transactional
    fun execute(loginUserRequest: LoginUserRequest): TokenResponse {
        val user = userFacade.getUserByEmail(loginUserRequest.email)

        if (!passwordEncoder.matches(loginUserRequest.password, user.password)) {
            throw PasswordMissMatchedException.EXCEPTION
        }

        val token = jwtTokenProvider.getToken(loginUserRequest.email)
        val expiredAt = jwtTokenParser.getExpiredTime()

        return TokenResponse(
            accessToken = token.accessToken,
            refreshToken = token.refreshToken,
            expiredAt = expiredAt
        )
    }
}
