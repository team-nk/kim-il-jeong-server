package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleByMapRequest
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleByMapElement
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleByMapListResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import java.time.LocalDateTime

@Service
class QueryScheduleByMapService(
    private val scheduleRepository: ScheduleRepository,
    private val userFacade: UserFacade
) {

    @Transactional(readOnly = true)
    fun execute(request: ScheduleByMapRequest): ScheduleByMapListResponse {
        val user = userFacade.getCurrentUser()
        val scheduleList = scheduleRepository.findAllSchedule(request.latitude, request.longitude, request.distance)
            .filter {
                isToday(it) && it.user == user
            }
            .map {
                ScheduleByMapElement(
                    scheduleId = it.id,
                    content = it.content,
                    address = it.address,
                    color = it.color
                )
            }

        return ScheduleByMapListResponse(scheduleList)
    }

    private fun isToday(schedule: Schedule): Boolean {
        val date = LocalDateTime.now()
        val startTime = schedule.startTime
        val tomorrow = date.plusDays(1)

        return startTime.isAfter(date) && startTime.isBefore(tomorrow)
    }
}