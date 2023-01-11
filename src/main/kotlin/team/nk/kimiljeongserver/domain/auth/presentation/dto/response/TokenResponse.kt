package team.nk.kimiljeongserver.domain.auth.presentation.dto.response

import java.time.LocalDateTime

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val expiredAt: LocalDateTime
)