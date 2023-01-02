package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import java.time.LocalDate
import javax.validation.constraints.NotNull

data class ModifyBirthdayRequest(

    val birthday: LocalDate
)