package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.LocationScheduleElement
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.LocationScheduleListResponse
import team.nk.kimiljeongserver.domain.user.facade.UserFacade

@Service
class QueryLocationScheduleService(
    private val userFacade: UserFacade,
    private val scheduleRepository: ScheduleRepository
) {

    @Transactional(readOnly = true)
    fun execute(): LocationScheduleListResponse {
        val user = userFacade.getCurrentUser()
        val list = scheduleRepository.findAllByUserOrderByStartTimeDesc(user)?.map {
            LocationScheduleElement(
                scheduleId = it.id,
                latitude = it.latitude,
                longitude = it.longitude,
                address = it.address
            )
        }

        return LocationScheduleListResponse(list)
    }
}