package com.example.projectsapi.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {

    @Bean
    fun publicApiV1(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("projects-api")
            .pathsToMatch("/api2/**")
            .build()
    }

    @Bean
    fun aniFoxOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("projects API")
                    .description("projects Application API")
            )
    }

}