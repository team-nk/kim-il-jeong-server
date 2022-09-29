package team.nk.kimiljeongserver.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import javax.validation.constraints.NotBlank

@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 2)
class RefreshToken(
    @Id
    val email: String,

    @Indexed
    @NotBlank
    val token: String
)