package team.nk.kimiljeongserver.domain.schedule.exception

import team.nk.kimiljeongserver.domain.schedule.exception.properties.ScheduleErrorCode
import team.nk.kimiljeongserver.global.error.exception.KimIlJeongException

object ScheduleNotFoundException : KimIlJeongException(ScheduleErrorCode.SCHEDULE_NOT_FOUND) {
    val EXCEPTION = ScheduleNotFoundException
}