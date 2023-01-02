package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import java.time.LocalDate
import javax.validation.constraints.NotBlank

data class ModifyBirthdayRequest(

    @field: NotBlank(message = "birthday는 필수 입력입니다.")
    val birthday: LocalDate
)