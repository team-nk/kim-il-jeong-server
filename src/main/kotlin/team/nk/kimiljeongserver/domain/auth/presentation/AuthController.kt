package team.nk.kimiljeongserver.domain.auth.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.auth.service.ReissueService

@Tag(name = "인증", description = "인증 관련 API입니다.")
@RequestMapping("/auth")
@RestController
class AuthController(
    private val reissueService: ReissueService
) {

    @Operation(summary = "토큰 재발급")
    @PutMapping
    fun tokenReissue(@RequestHeader("Refresh-Token") refreshToken: String): TokenResponse {
        return reissueService.execute(refreshToken)
    }
}