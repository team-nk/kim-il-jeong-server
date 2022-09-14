package com.example.kimiljeongserver.domain.user.domain

import com.example.kimiljeongserver.global.entity.BaseUUIDEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Table(name = "tbl_user")
@Entity
class UserEntity(

    override val id: UUID,

    @field:NotNull
    val email: String,

    @field:Size(max = 30)
    @field:NotNull
    val accountId: String,

    @field:Size(max = 60)
    @field:NotNull
    val password: String
) : BaseUUIDEntity()
