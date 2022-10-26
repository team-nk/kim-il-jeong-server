package team.nk.kimiljeongserver.domain.schedule.exception.properties

import org.springframework.http.HttpStatus
import team.nk.kimiljeongserver.global.error.ErrorProperty

enum class ScheduleErrorCode(
    private val status: HttpStatus,
    private val message: String
) : ErrorProperty {

    SCHEDULE_NOT_FOUND(HttpStatus.NOT_FOUND, "Schedule Not Found");

    override fun status() = status.value()
    override fun message() = message
}