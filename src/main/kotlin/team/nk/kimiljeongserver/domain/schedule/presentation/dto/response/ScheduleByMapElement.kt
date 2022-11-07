package team.nk.kimiljeongserver.domain.schedule.presentation.dto.response

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color

data class ScheduleByMapElement(
    val scheduleId: Int,
    val content: String,
    val address: String,
    val color: Color
)