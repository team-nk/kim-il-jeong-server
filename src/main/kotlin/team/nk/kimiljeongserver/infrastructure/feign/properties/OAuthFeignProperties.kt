package team.nk.kimiljeongserver.infrastructure.feign.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "auth")
@ConstructorBinding
data class OAuthFeignProperties(
    val googleClientId: String,
    val kakaoRestId: String
)
