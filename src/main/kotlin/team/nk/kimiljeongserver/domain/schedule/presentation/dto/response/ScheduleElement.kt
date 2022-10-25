package team.nk.kimiljeongserver.domain.schedule.presentation.dto.response

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import java.time.LocalDateTime

data class ScheduleElement(
    val scheduleId: Int,
    val content: String,
    val color: Color,
    val time: LocalDateTime,
    val isAlways: Boolean
)
