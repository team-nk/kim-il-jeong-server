package com.example.kimiljeongdomain.user

import com.example.kimiljeongdomain.annotation.Aggregate
import java.util.*

@Aggregate
class User(
    val id: UUID,

    val email: String,

    val accountId: String,

    val password: String
)
