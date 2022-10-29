package team.nk.kimiljeongserver.domain.post.presentation.dto.response

import com.querydsl.core.annotations.QueryProjection
import java.time.LocalDate

class UserBirthdayElement @QueryProjection constructor(
    val accountId: String,
    val age: Int,
    val birthday: LocalDate
)