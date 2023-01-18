package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.facade.ScheduleFacade
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleRequest
import team.nk.kimiljeongserver.domain.user.service.oauth.KakaoOAuthService

@Service
class ModifyScheduleService(
    private val scheduleFacade: ScheduleFacade,
    private val kakaoOAuthService: KakaoOAuthService
) {

    @Transactional
    fun execute(scheduleId: Int, scheduleRequest: ScheduleRequest) {

        val schedule = scheduleFacade.getScheduleById(scheduleId)
        val response = kakaoOAuthService.getLocation(scheduleRequest.address)

        schedule.modifySchedule(
            content = scheduleRequest.content,
            address = scheduleRequest.address,
            buildingName = response.buildingName,
            latitude = response.x,
            longitude = response.y,
            color = scheduleRequest.color,
            isAlways = scheduleRequest.isAlways,
            startTime = scheduleRequest.startTime,
            endTime = scheduleRequest.endTime
        )
    }
}