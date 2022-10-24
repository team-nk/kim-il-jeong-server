package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleRequest

@Service
class CreateScheduleService(
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional
    fun execute(scheduleRequest: ScheduleRequest) {
        scheduleRepository.save(
            Schedule(
                content = scheduleRequest.content,
                location = scheduleRequest.location,
                color = scheduleRequest.color,
                isAlways = scheduleRequest.isAlways,
                createdAt = scheduleRequest.createTime,
                endTime = scheduleRequest.endTime
            )
        )
    }
}