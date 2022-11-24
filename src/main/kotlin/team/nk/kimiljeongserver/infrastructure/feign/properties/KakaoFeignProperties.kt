package team.nk.kimiljeongserver.infrastructure.feign.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "auth.kakao")
@ConstructorBinding
data class KakaoFeignProperties(
    val clientId: String,
)