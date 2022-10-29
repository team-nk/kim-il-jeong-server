package team.nk.kimiljeongserver.domain.post.domain

import org.hibernate.validator.constraints.Length
import team.nk.kimiljeongserver.domain.schedule.domain.Schedule
import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.global.entity.BaseEntity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*
import javax.validation.constraints.NotNull


@Entity
@Table(name = "tbl_post")
class Post(

    @field:NotNull
    @Length(max = 20)
    val title: String,

    @field:NotNull
    val content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    val schedule: Schedule

) : BaseEntity()