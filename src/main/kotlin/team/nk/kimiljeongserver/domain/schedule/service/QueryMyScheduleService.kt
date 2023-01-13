package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleElement
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleListResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Service
class QueryMyScheduleService(
    private val userFacade: UserFacade,
    private val scheduleRepository: ScheduleRepository
) {

    fun execute(): ScheduleListResponse {
        val user = userFacade.getCurrentUser()

        val list = scheduleRepository.findAllByUserOrderByStartTimeDesc(user)?.map {
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
}