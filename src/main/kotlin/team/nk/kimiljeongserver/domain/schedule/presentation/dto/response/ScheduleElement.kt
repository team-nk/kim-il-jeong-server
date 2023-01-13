package team.nk.kimiljeongserver.domain.schedule.presentation.dto.response

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import java.time.LocalDateTime

data class ScheduleElement(
    val scheduleId: Int,
    val content: String,
    val color: Color,
    val address: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val isAlways: Boolean
)
