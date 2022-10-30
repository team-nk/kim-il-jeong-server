package team.nk.kimiljeongserver.domain.comment.domain

import team.nk.kimiljeongserver.domain.post.domain.Post
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.global.entity.BaseEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_comment")
class Comment(

    @field:NotNull
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    val post: Post
) : BaseEntity()