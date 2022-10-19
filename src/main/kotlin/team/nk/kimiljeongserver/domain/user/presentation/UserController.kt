package team.nk.kimiljeongserver.domain.user.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.auth.presentation.dto.response.TokenResponse
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.LoginUserRequest
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.SaveUserRequest
import team.nk.kimiljeongserver.domain.user.service.LoginUserService
import team.nk.kimiljeongserver.domain.user.service.SignupUserService
import javax.validation.Valid

@Tag(name = "유저", description = "유저 관련 API입니다.")
@RequestMapping("/user")
@RestController
class UserController(
    private val signupUserService: SignupUserService,
    private val loginUserService: LoginUserService
) {

    @Operation(summary = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun signup(@Valid @RequestBody request: SaveUserRequest) {
        signupUserService.execute(request)
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    fun signup(@Valid @RequestBody request: LoginUserRequest): TokenResponse {
        return loginUserService.execute(request)
    }
}
