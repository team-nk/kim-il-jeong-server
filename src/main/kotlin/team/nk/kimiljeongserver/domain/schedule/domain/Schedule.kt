package team.nk.kimiljeongserver.domain.schedule.domain

import org.hibernate.validator.constraints.Length
import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import team.nk.kimiljeongserver.domain.user.domain.User
import team.nk.kimiljeongserver.global.entity.BaseEntity
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_schedule")
class Schedule(

    content: String,

    latitude: Double,

    longitude: Double,

    color: Color,

    isAlways: Boolean,

    startTime: LocalDateTime,

    endTime: LocalDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User

) : BaseEntity() {

    @field:NotNull
    @Length(max = 100)
    var content = content
        protected set

    @field: NotNull
    var latitude = latitude
        protected set

    @field: NotNull
    var longitude = longitude
        protected set

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    var color = color
        protected set

    @NotNull
    var isAlways = isAlways
        protected set

    @NotNull
    var startTime = startTime
        protected set

    @NotNull
    var endTime = endTime
        protected set

    fun modifySchedule(
        content: String,
        latitude: Double,
        longitude: Double,
        color: Color,
        isAlways: Boolean,
        startTime: LocalDateTime,
        endTime: LocalDateTime
    ) {
        this.content = content
        this.latitude = latitude
        this.longitude = longitude
        this.color = color
        this.isAlways = isAlways
        this.startTime = startTime
        this.endTime = endTime
    }
}
