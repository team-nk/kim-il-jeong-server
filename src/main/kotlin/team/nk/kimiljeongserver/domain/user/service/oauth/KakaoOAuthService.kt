package team.nk.kimiljeongserver.domain.user.service.oauth

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.domain.user.domain.repository.UserRepository
import team.nk.kimiljeongserver.global.security.jwt.JwtTokenProvider
import team.nk.kimiljeongserver.infrastructure.feign.client.KakaoLocationClient
import team.nk.kimiljeongserver.infrastructure.feign.dto.request.KakaoUserInfoRequest
import team.nk.kimiljeongserver.infrastructure.feign.dto.response.KakaoRoadAddressResponse
import team.nk.kimiljeongserver.infrastructure.feign.properties.OAuthFeignProperties

@Service
class KakaoOAuthService(
    private val oAuthFeignProperties: OAuthFeignProperties,
    private val userRepository: UserRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val kakaoLocationClient: KakaoLocationClient,
    @Value("\${auth.kakaoak}")
    val authorization: String
) {

    fun getClientId(): String {
        return oAuthFeignProperties.kakaoRestId
    }

    fun saveUser(kakaoUserInfoRequest: KakaoUserInfoRequest): ResponseEntity<TokenResponse> {

        var user = userRepository.findByEmail(kakaoUserInfoRequest.email)
        var status = HttpStatus.OK

        if (user == null) {
            user = User(
                email = kakaoUserInfoRequest.email,
                accountId = kakaoUserInfoRequest.nickname,
                profile = kakaoUserInfoRequest.profileImage,
                password = null
            )
            status = HttpStatus.CREATED
        }

        return ResponseEntity<TokenResponse>(jwtTokenProvider.getToken(user.email), status)
    }

    fun getLocation(query: String): KakaoRoadAddressResponse {
        val response = kakaoLocationClient.getLocation(
            query = query,
            authorization = authorization
        ).documents[0].roadAddress


        return KakaoRoadAddressResponse(
            x = response.x,
            y = response.y,
            buildingName = response.buildingName
        )
    }
}
