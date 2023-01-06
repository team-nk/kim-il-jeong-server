package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleByMapRequest
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleByMapElement
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleByMapListResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Service
class QueryScheduleByMapService(
    private val scheduleRepository: ScheduleRepository,
    private val userFacade: UserFacade
) {

    @Transactional(readOnly = true)
    fun execute(request: ScheduleByMapRequest): ScheduleByMapListResponse {
        val user = userFacade.getCurrentUser()
        //val scheduleList = scheduleRepository.findAllSchedule(request.latitude, request.longitude, request.distance)
        val scheduleList = scheduleRepository.findAll()
            .filter {
                //isToday &&
                it.user == user
            }
            .map {
                ScheduleByMapElement(
                    scheduleId = it.id,
                    content = it.content,
                    address = it.address,
                    color = it.color,
                    startTime = it.startTime,
                    endTime = it.endTime
                )
            }

        return ScheduleByMapListResponse(scheduleList)
    }
/*
    private fun isToday(schedule: Schedule): Boolean {
        val date = LocalDateTime.now()
        val startTime = schedule.startTime
        val tomorrow = date.plusDays(1)

        return startTime.isAfter(date) && startTime.isBefore(tomorrow)
    }*/
}