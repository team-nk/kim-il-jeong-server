package team.nk.kimiljeongserver.domain.user.service.oauth

import org.springframework.stereotype.Service
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenProvider
import team.nk.kimiljeongserver.infrastructure.feign.dto.request.KakaoUserInfoRequest
import team.nk.kimiljeongserver.infrastructure.feign.properties.KakaoFeignProperties

@Service
class KakaoOAuthService(
    private val kakaoFeignProperties: KakaoFeignProperties,
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun getClientId(): String {
        return kakaoFeignProperties.clientId
    }

    fun saveUser(kakaoUserInfoRequest: KakaoUserInfoRequest): TokenResponse {

        var user = userRepository.findByEmail(kakaoUserInfoRequest.email)

        if (user == null) {
            user = User(
                email = kakaoUserInfoRequest.email,
                accountId = kakaoUserInfoRequest.nickname,
                profile = kakaoUserInfoRequest.profileImage
            )
            userRepository.save(user)
        }

        return jwtTokenProvider.getToken(user.email)
    }
}
