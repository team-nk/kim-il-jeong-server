package team.nk.kimiljeongserver.domain.comment.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDateTime

class CommentVO @QueryProjection constructor(
    val content: String,
    val accountId: String,
    val profile: String,
    val createTime: LocalDateTime
)