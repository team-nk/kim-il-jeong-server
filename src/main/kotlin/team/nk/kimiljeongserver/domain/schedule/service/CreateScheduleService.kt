package team.nk.kimiljeongserver.domain.schedule.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.schedule.domain.repository.ScheduleRepository
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleRequest
import team.nk.kimiljeongserver.domain.user.facade.UserFacade
import team.nk.kimiljeongserver.domain.user.service.oauth.KakaoOAuthService

@Service
class CreateScheduleService(
    private val userFacade: UserFacade,
    private val scheduleRepository: ScheduleRepository,
    private val kakaoOauthService: KakaoOAuthService,
    ) {

    @Transactional
    fun execute(scheduleRequest: ScheduleRequest) {

        val user = userFacade.getCurrentUser()
        val response = kakaoOauthService.getLocation(scheduleRequest.address)

        scheduleRepository.save(
            Schedule(
                content = scheduleRequest.content,
                address = scheduleRequest.address,
                color = scheduleRequest.color,
                latitude = response.x,
                longitude = response.y,
                isAlways = scheduleRequest.isAlways,
                startTime = scheduleRequest.startTime,
                endTime = scheduleRequest.endTime,
                user = user
            )
        )
    }
}