package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class SaveUserRequest(

    @field: Email
    @field: NotBlank(message = "email은 필수 입력입니다.")
    val email: String,

    val code: String,

    @field:Size(min = 5, max = 20, message = "accountId는 5~20자리 이내로 이내로 입력해주세요.")
    @field:NotBlank(message = "accountId는 필수 입력입니다.")
    val accountId: String,

    @field:Pattern(
        regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}$",
        message = "password는 영문자와 숫자, 특수문자를 모두 포함해서 8~16자리 이내로 입력해주세요."
    )
    @field:NotBlank
    val password: String,

    val rePassword: String
)
