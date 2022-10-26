package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.facade.ScheduleFacade
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleRequest

@Service
class ModifyScheduleService(
    private val scheduleFacade: ScheduleFacade
) {

    @Transactional
    fun execute(scheduleId: Int, scheduleRequest: ScheduleRequest) {

        val schedule = scheduleFacade.getScheduleById(scheduleId)

        schedule.modifySchedule(
            content = scheduleRequest.content,
            latitude = scheduleRequest.latitude,
            longitude = scheduleRequest.longitude,
            color = scheduleRequest.color,
            isAlways = scheduleRequest.isAlways,
            startTime = scheduleRequest.startTime,
            endTime = scheduleRequest.endTime
        )
    }
}