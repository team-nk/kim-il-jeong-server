package team.nk.kimiljeongserver.domain.schedule.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleRequest
import team.nk.kimiljeongserver.domain.schedule.service.CreateScheduleService
import javax.validation.Valid

@Tag(name = "일정", description = "일정 관련 API입니다.")
@RequestMapping("/schedule")
@RestController
class ScheduleController(
    private val createScheduleService: CreateScheduleService
) {

    @Operation(summary = "일정 생성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createSchedule(@Valid @RequestBody request: ScheduleRequest) {
        createScheduleService.execute(request)
    }
}