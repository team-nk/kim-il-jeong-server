package team.nk.kimiljeongserver.global.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("KimIlJeong API")
                    .description("KimIlJeong Api 명세서입니다.")
                    .version("v1")
            )
    }
}
