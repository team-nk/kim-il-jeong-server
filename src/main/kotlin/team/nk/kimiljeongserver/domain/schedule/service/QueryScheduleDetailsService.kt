package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.facade.ScheduleFacade
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleDetailsResponse

@Service
class QueryScheduleDetailsService(
    private val scheduleFacade: ScheduleFacade
) {

    @Transactional(readOnly = true)
    fun execute(scheduleId: Int): ScheduleDetailsResponse {
        val schedule = scheduleFacade.getScheduleById(scheduleId)
        return ScheduleDetailsResponse(
            content = schedule.content,
            color = schedule.color,
            address = schedule.address,
            startTime = schedule.startTime,
            endTime = schedule.endTime,
            isAlways = schedule.isAlways
        )
    }
}