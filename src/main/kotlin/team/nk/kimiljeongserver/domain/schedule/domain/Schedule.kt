package team.nk.kimiljeongserver.domain.schedule.domain

import org.hibernate.validator.constraints.Length
import team.nk.kimiljeongserver.domain.schedule.domain.type.Color
import team.nk.kimiljeongserver.global.entity.BaseEntity
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_schedule")
class Schedule(

    override val createdAt: LocalDateTime,

    content: String,

    location: String,

    color: Color,

    isAlways: Boolean,

    endTime: LocalDateTime

) : BaseEntity() {

    @field:NotNull
    @Length(max = 100)
    var content =  content
        protected set

    @field:NotNull
    var location = location
        protected set

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    var color = color
        protected set

    @NotNull
    var isAlways = isAlways
        protected set

    @NotNull
    var endTime = endTime
        protected set

}
