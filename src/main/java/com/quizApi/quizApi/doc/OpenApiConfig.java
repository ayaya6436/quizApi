package com.quizApi.quizApi.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("QuizApi")
                                 .description("QuizApi est une api concu pour gerer le développement d'application pour faire des quiz avec Java Spring Boot vise à offrir une plateforme interactive et conviviale pour la création et la participation à des quiz. Avec des fonctionnalités telles que la création de comptes utilisateurs, la gestion de quiz.")
                                 .version("1.0"));
    }
}