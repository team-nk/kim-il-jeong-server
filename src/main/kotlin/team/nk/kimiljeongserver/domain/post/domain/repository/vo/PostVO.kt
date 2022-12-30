package team.nk.kimiljeongserver.domain.post.domain.repository.vo

import com.querydsl.core.annotations.QueryProjection
import team.nk.kimiljeongserver.domain.post.domain.Post
import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import java.time.LocalDateTime

class PostVO @QueryProjection constructor(
    val id: Int,
    val title: String,
    val content: String,
    val scheduleContent: String,
    val address: String,
    val color: Color,
    val accountId: String,
    val createdAt: LocalDateTime,
    val isMine: Boolean,
    val post: Post
)
