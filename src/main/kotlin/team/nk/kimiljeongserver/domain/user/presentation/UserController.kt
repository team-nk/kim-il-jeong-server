package team.nk.kimiljeongserver.domain.user.presentation

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.user.presentation.dto.request.SaveUserRequest
import team.nk.kimiljeongserver.domain.user.service.SignupUserService
import javax.validation.Valid

@RequestMapping("/user")
@RestController
class UserController(
    private val signupUserService: SignupUserService
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun signup(@Valid @RequestBody request: SaveUserRequest) {
        signupUserService.execute(request)
    }
}
