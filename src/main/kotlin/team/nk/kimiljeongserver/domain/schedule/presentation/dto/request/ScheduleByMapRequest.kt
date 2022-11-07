package team.nk.kimiljeongserver.domain.schedule.presentation.dto.request

import java.math.BigDecimal
import javax.validation.constraints.NotNull

data class ScheduleByMapRequest(
    @field: NotNull
    val latitude: BigDecimal,

    @field: NotNull
    val longitude: BigDecimal,

    @field: NotNull
    val distance: BigDecimal
)