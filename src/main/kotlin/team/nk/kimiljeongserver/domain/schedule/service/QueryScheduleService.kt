package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleElement
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleListResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import java.time.LocalDateTime


@Service
class QueryScheduleService(
    private val userFacade: UserFacade,
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional(readOnly = true)
    fun execute(date: LocalDateTime): ScheduleListResponse {
        val user = userFacade.getCurrentUser()

        val list = scheduleRepository.findAllByUserOrderByStartTimeAsc(user)?.filter {
            isToday(date, it)
        }?.map {
            ScheduleElement(
                scheduleId = it.id,
                content = it.content,
                color = it.color,
                address = it.address,
                startTime = it.startTime,
                endTime = it.endTime,
                isAlways = it.isAlways
            )
        }

        return ScheduleListResponse(list)
    }

    private fun isToday(date: LocalDateTime, schedule: Schedule): Boolean {
        val startTime = schedule.startTime
        val tomorrow = date.plusDays(1)

        return startTime.isAfter(date) && startTime.isBefore(tomorrow)
    }
}

