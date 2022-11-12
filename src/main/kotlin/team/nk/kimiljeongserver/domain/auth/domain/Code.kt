package team.nk.kimiljeongserver.domain.auth.domain

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed
import javax.validation.constraints.NotBlank

@RedisHash
class Code(

    @Id
    @Indexed
    val email: String,

    @NotBlank
    val value: String,
)