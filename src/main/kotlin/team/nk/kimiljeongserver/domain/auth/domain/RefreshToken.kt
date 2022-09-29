package team.nk.kimiljeongserver.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed
import javax.validation.constraints.NotBlank

@RedisHash
class RefreshToken(
    @Id
    val email: String,

    @Indexed
    @NotBlank
    val token: String,

    @TimeToLive
    val timeToLive: Long
)