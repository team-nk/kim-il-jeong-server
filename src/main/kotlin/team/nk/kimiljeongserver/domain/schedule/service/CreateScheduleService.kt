package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleRequest
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Service
class CreateScheduleService(
    private val userFacade: UserFacade,
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional
    fun execute(scheduleRequest: ScheduleRequest) {

        val user = userFacade.getCurrentUser()

        scheduleRepository.save(
            Schedule(
                content = scheduleRequest.content,
                address = scheduleRequest.address,
                color = scheduleRequest.color,
                isAlways = scheduleRequest.isAlways,
                startTime = scheduleRequest.startTime,
                endTime = scheduleRequest.endTime,
                user = user
            )
        )
    }
}