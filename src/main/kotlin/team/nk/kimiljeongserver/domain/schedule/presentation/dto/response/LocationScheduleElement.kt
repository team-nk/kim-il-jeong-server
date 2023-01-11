package team.nk.kimiljeongserver.domain.schedule.presentation.dto.response

data class LocationScheduleElement(
    val scheduleId: Int,
    val latitude: Double?,
    val longitude: Double?,
    val address: String
)