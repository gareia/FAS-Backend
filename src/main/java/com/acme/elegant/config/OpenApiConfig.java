package com.acme.elegant.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean(name = "elegantOpenApi")
    public OpenAPI elegantOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Elegant API")
                        .description(
                                "Aplicación de moda masculina"));
    }
}