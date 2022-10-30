package team.nk.kimiljeongserver.domain.schedule.presentation.dto.response

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color

data class ChooseScheduleElement(
    val scheduleId: Int,
    val content: String,
    val color: Color,
    val address: String
)