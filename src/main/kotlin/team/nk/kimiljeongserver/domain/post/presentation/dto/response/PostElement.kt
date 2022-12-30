package team.nk.kimiljeongserver.domain.post.presentation.dto.response

import team.nk.kimiljeongserver.domain.schedule.domain.type.Color

data class PostElement(
    val id: Int,
    val title: String,
    val content: String,
    val scheduleContent: String,
    val address: String,
    val color: Color,
    val commentCount: Int,
    val isMine: Boolean,
    val accountId: String,
    val createTime: String,
)