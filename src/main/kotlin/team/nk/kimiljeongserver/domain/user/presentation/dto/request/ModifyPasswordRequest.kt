package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class ModifyPasswordRequest(

    @field: NotBlank(message = "password은 필수 입력입니다.")
    val nowPassword: String,

    @field: NotBlank(message = "newPassword은 필수 입력입니다.")
    val newPassword: String,

    @field: NotBlank(message = "newPassword2는 필수 입력입니다.")
    val new2Password: String
)