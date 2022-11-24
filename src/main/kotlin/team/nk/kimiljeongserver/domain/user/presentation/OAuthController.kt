package team.nk.kimiljeongserver.domain.user.presentation

import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.service.oauth.GoogleOAuthService
import team.nk.kimiljeongserver.domain.user.service.oauth.KakaoOAuthService
import team.nk.kimiljeongserver.infrastructure.feign.dto.request.KakaoUserInfoRequest
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

    @GetMapping("/google/token")
    fun googleInfo(@RequestParam idToken: String): TokenResponse {
        return googleOAuthService.getInfo(idToken)
    }

    @GetMapping("/kakao")
    fun kakaoClikentId(): String {
        return kakaoOAuthService.getClientId()
    }

    @GetMapping("/kakao/user")
    fun kakaoCode(@RequestBody @Valid kakaoUserInfoRequest: KakaoUserInfoRequest): TokenResponse {
        return kakaoOAuthService.saveUser(kakaoUserInfoRequest)
    }
}