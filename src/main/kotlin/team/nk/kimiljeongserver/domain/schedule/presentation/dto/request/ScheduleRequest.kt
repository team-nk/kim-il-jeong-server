package team.nk.kimiljeongserver.domain.schedule.presentation.dto.request

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class ScheduleRequest(

    @field:Size(max = 100, message = "content는 100자리 이내로 이내로 입력해주세요.")
    @field: NotBlank(message = "content는 필수 입력입니다.")
    val content: String,

    val address: String,

    val latitude: Double,

    val longitude: Double,

    val color: Color,

    val isAlways: Boolean,

    val startTime: LocalDateTime,

    val endTime: LocalDateTime
)
