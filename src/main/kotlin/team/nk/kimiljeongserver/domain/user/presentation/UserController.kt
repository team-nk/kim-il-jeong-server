package team.nk.kimiljeongserver.domain.user.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.SaveUserRequest
import team.nk.kimiljeongserver.domain.user.service.SignupUserService
import javax.validation.Valid

@Tag(name = "유저", description = "유저 관련 API입니다.")
@RequestMapping("/user")
@RestController
class UserController(
    private val signupUserService: SignupUserService
) {

    @Operation(summary = "회원가입")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun signup(@Valid @RequestBody request: SaveUserRequest) {
        signupUserService.execute(request)
    }
}
