/*
package team.nk.kimiljeongserver.global.config

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsyncClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import team.nk.kimiljeongserver.infrastructure.aws.email.AwsSESProperties

@Configuration
class AwsSESConfig(
    val awsSESProperties: AwsSESProperties
) {
    @Bean
    fun amazonSimpleEmailService(): AmazonSimpleEmailServiceAsync {
        val credentials = BasicAWSCredentials(
            awsSESProperties.accessKey,
            awsSESProperties.secretKey
        )

        return AmazonSimpleEmailServiceAsyncClient.asyncBuilder()
            .withCredentials(AWSStaticCredentialsProvider(credentials))
            .withRegion(awsSESProperties.region)
            .build()
    }
}*/
