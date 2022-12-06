package team.nk.kimiljeongserver.domain.user.service.oauth

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenProvider
import team.nk.kimiljeongserver.infrastructure.feign.client.GoogleTokenClient
import team.nk.kimiljeongserver.infrastructure.feign.properties.OAuthFeignProperties

@Service
class GoogleOAuthService(
    private val googleTokenClient: GoogleTokenClient,
    private val oAuthFeignProperties: OAuthFeignProperties,
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun getClientId(): String {
        return oAuthFeignProperties.googleClientId
    }

    fun getInfo(idToken: String): ResponseEntity<TokenResponse> {
        val response = googleTokenClient.checkIdToken(
            idToken = idToken
        )

        var user = userRepository.findByEmail(response.email)
        var status = HttpStatus.OK

        if (user == null) {
            user = User(
                email = response.email,
                accountId = response.name,
                profile = response.picture,
                password = null
            )
            userRepository.save(user)
            status = HttpStatus.CREATED
        }

        return ResponseEntity<TokenResponse>(jwtTokenProvider.getToken(user.email), status)
    }
}