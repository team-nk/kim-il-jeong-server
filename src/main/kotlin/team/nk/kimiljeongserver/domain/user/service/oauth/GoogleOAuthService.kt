package team.nk.kimiljeongserver.domain.user.service.oauth

import org.springframework.stereotype.Service
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenProvider
import team.nk.kimiljeongserver.infrastructure.feign.client.GoogleTokenClient
import team.nk.kimiljeongserver.infrastructure.feign.properties.GoogleFeignProperties

@Service
class GoogleOAuthService(
    private val googleTokenClient: GoogleTokenClient,
    private val googleFeignProperties: GoogleFeignProperties,
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun getClientId(): String {
        return googleFeignProperties.clientId
    }

    fun getInfo(idToken: String): TokenResponse {
        val response = googleTokenClient.checkIdToken(
            idToken = idToken
        )

        val email = response.email
        val name = response.name
        val picture = response.picture

        var user = userRepository.findByEmail(email)

        if (user == null) {
            user = User(
                email = email,
                accountId = name,
                profile = picture
            )
            userRepository.save(user)
        }

        return jwtTokenProvider.getToken(user.email)
    }
}