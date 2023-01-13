package team.nk.kimiljeongserver.domain.schedule.presentation.dto.response

data class LocationScheduleElement(
    val scheduleId: Int,
    val latitude: String,
    val longitude: String,
    val address: String
)