package team.nk.kimiljeongserver.infrastructure.aws.email

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "aws.ses")
data class AwsSESProperties(
    val accessKey: String,
    val secretKey: String,
    val sesSource: String,
    val region: String
)
