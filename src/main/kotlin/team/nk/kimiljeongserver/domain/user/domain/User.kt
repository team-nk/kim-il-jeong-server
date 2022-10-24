package team.nk.kimiljeongserver.domain.user.domain

import org.hibernate.validator.constraints.Length
import team.nk.kimiljeongserver.global.entity.BaseEntity
import team.nk.kimiljeongserver.infrastructure.aws.defaultImage.DefaultImage
import java.time.ZonedDateTime
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_user")
class User(

    @field:NotNull
    val email: String,

    @field:NotNull
    @Length(min = 5, max = 20)
    val accountId: String,

    password: String,

    birthday: ZonedDateTime = ZonedDateTime.now(),

    profile: String = DefaultImage.PROFILE_IMAGE

) : BaseEntity() {

    @field:NotNull
    @Length(max = 60)
    var password = password
        protected set

    @field:NotNull
    var birthday = birthday
        protected set

    @field:NotNull
    var profile = profile
        protected set

    fun modifyBirthday(birthday: ZonedDateTime) {
        this.birthday = birthday
    }
}
