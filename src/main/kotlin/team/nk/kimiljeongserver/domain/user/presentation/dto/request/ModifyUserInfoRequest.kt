package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class ModifyUserInfoRequest(

    @field: NotBlank(message = "email은 필수 입력입니다.")
    val email: String,

    @field: NotBlank(message = "accountId는 필수 입력입니다.")
    val accountId: String,

    @field: NotBlank(message = "profile은 필수 입력입니다.")
    val profile: String
)
