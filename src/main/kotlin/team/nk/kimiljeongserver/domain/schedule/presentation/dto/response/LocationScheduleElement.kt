package team.nk.kimiljeongserver.domain.schedule.presentation.dto.response

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color

data class LocationScheduleElement(
    val scheduleId: Int,
    val latitude: String,
    val longitude: String,
    val buildingName: String,
    val color: Color
)