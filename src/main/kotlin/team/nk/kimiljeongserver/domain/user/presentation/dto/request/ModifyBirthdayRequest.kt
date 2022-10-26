package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import java.time.LocalDate

data class ModifyBirthdayRequest(
    val birthday: LocalDate
)