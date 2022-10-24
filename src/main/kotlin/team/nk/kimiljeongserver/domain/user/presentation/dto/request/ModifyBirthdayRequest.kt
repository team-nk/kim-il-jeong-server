package team.nk.kimiljeongserver.domain.user.presentation.dto.request

import java.time.LocalDateTime

data class ModifyBirthdayRequest(
    val birthday: LocalDateTime
)