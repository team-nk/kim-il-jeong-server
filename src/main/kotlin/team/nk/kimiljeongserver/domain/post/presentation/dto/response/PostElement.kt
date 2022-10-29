package team.nk.kimiljeongserver.domain.post.presentation.dto.response

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import java.time.LocalDateTime

data class PostElement(
    val title: String,
    val scheduleContent: String,
    val address: String,
    val color: Color,
    val accountId: String,
    val createTime: String
)