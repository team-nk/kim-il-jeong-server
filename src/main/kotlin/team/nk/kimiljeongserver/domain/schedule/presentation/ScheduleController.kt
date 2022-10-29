package team.nk.kimiljeongserver.domain.schedule.presentation

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.format.annotation.DateTimeFormat.ISO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.request.ScheduleRequest
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ChooseScheduleListResponse
import team.nk.kimiljeongserver.domain.schedule.presentation.dto.response.ScheduleListResponse
import team.nk.kimiljeongserver.domain.schedule.service.*
import java.time.LocalDateTime
import javax.validation.Valid

@Tag(name = "일정", description = "일정 관련 API입니다.")
@RequestMapping("/schedule")
@RestController
class ScheduleController(
    private val createScheduleService: CreateScheduleService,
    private val modifyScheduleService: ModifyScheduleService,
    private val deleteScheduleService: DeleteScheduleService,
    private val queryScheduleService: QueryScheduleService,
    private val queryMyScheduleService: QueryMyScheduleService,
    private val chooseScheduleService: QueryChooseScheduleService
) {

    @Operation(summary = "일정 생성")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createSchedule(@Valid @RequestBody request: ScheduleRequest) {
        createScheduleService.execute(request)
    }

    @Operation(summary = "일정 수정")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{schedule-id}")
    fun modifySchedule(@PathVariable("schedule-id") scheduleId: Int, @Valid @RequestBody request: ScheduleRequest) {
        modifyScheduleService.execute(scheduleId, request)
    }

    @Operation(summary = "일정 삭제")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{schedule-id}")
    fun deleteSchedule(@PathVariable("schedule-id") scheduleId: Int) {
        deleteScheduleService.execute(scheduleId)
    }

    @Operation(summary = "자신의 일정 일별 보기")
    @GetMapping
    fun querySchedule(@RequestParam(value = "date") @DateTimeFormat(iso = ISO.DATE_TIME) date: LocalDateTime): ScheduleListResponse {
        return queryScheduleService.execute(date)
    }

    @Operation(summary = "자신의 전체 일정 보기")
    @GetMapping("/list")
    fun querySchedule(): ScheduleListResponse {
        return queryMyScheduleService.execute()
    }

    @Operation(summary = "일정 선택 리스트 보기")
    @GetMapping("/choose")
    fun queryChooseSchedule(): ChooseScheduleListResponse {
        return chooseScheduleService.execute()
    }

}