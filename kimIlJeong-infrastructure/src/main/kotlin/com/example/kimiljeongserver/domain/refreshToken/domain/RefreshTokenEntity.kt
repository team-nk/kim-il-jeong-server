package com.example.kimiljeongserver.domain.refreshToken.domain

import java.util.*

data class RefreshTokenEntity(
    val tokenValue: String,
    val userId: UUID
)