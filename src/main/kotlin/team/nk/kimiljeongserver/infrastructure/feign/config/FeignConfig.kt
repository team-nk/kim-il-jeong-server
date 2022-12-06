package team.nk.kimiljeongserver.infrastructure.feign.config

import feign.codec.ErrorDecoder
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import team.nk.kimiljeongserver.infrastructure.feign.error.FeignClientErrorDecoder

@EnableFeignClients(basePackages = ["team.nk.kimiljeongserver"])
@Configuration
class FeignConfig {

    @Bean
    @ConditionalOnMissingBean(value = [ErrorDecoder::class])
    fun commonFeignErrorDecoder(): FeignClientErrorDecoder {
        return FeignClientErrorDecoder()
    }
}