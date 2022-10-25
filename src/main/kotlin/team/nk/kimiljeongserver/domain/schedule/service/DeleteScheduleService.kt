package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.facade.ScheduleFacade

@Service
class DeleteScheduleService(
    private val scheduleFacade: ScheduleFacade,
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional
    fun execute(scheduleId: Int) {
        val schedule = scheduleFacade.getScheduleById(scheduleId)
        scheduleRepository.delete(schedule)
    }
}