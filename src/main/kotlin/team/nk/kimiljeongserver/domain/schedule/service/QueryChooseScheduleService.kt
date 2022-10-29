package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ChooseScheduleElement
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ChooseScheduleListResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Service
class QueryChooseScheduleService(
    private val userFacade: UserFacade,
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional
    fun execute(): ChooseScheduleListResponse {
        val user = userFacade.getCurrentUser()
        val list = scheduleRepository.findAllByUserOrderByStartTimeDesc(user)?.map {
            ChooseScheduleElement(
                scheduleId = it.id,
                content = it.content,
                color = it.color,
                address = it.address
            )
        }

        return ChooseScheduleListResponse(list)
    }
}