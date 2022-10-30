package team.nk.kimiljeongserver.domain.comment.presentation.dto.response

import java.time.LocalDateTime

data class CommentElement(
    val content: String,
    val accountId: String,
    val profile: String,
    val createTime: LocalDateTime
)
