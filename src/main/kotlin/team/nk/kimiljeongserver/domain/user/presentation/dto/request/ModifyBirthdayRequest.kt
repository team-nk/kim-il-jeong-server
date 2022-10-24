package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import java.time.ZonedDateTime

data class ModifyBirthdayRequest(
    val birthday: ZonedDateTime
)