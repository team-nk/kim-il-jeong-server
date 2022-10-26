package team.nk.kimiljeongserver.domain.schedule.facade

import org.springframework.stereotype.Component
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.exception.ScheduleNotFoundException

@Component
class ScheduleFacade(
    private val scheduleRepository: ScheduleRepository
) {

    fun getScheduleById(scheduleId: Int): Schedule {
        return scheduleRepository.findScheduleById(scheduleId) ?: throw ScheduleNotFoundException.EXCEPTION
    }

}