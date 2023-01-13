package team.nk.kimiljeongserver.domain.user.presentation

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.service.oauth.GoogleOAuthService
import team.nk.kimiljeongserver.domain.user.service.oauth.KakaoOAuthService
import team.nk.kimiljeongserver.infrastructure.feign.dto.request.KakaoUserInfoRequest
import team.nk.kimiljeongserver.infrastructure.feign.dto.response.KakaoRoadAddressResponse
import javax.validation.Valid

@RequestMapping("/oauth")
@RestController
class OAuthController(
    private val googleOAuthService: GoogleOAuthService, private val kakaoOAuthService: KakaoOAuthService
) {

    @GetMapping("/google")
    fun googleClientId(): String {
        return googleOAuthService.getClientId()
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/google/token")
    fun googleInfo(@RequestParam idToken: String): ResponseEntity<TokenResponse> {
        return googleOAuthService.getInfo(idToken)
    }

    @GetMapping("/kakao")
    fun kakaoClikentId(): String {
        return kakaoOAuthService.getClientId()
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/kakao/user")
    fun kakaoCode(@RequestBody @Valid kakaoUserInfoRequest: KakaoUserInfoRequest): ResponseEntity<TokenResponse> {
        return kakaoOAuthService.saveUser(kakaoUserInfoRequest)
    }

    @GetMapping("/kakao/location")
    fun kakaoLocation(
        @RequestParam("query") query: String,
        @RequestHeader("Authorization") authorization: String
    ): KakaoRoadAddressResponse {
        return kakaoOAuthService.getLocation(query, authorization)
    }
}