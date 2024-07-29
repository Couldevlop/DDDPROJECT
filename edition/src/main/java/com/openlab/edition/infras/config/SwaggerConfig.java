package com.openlab.edition.infras.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
//import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentation")
                        .version("1.0")
                        .description("Documentation des API de l'application"));
    }

  /*  @Bean
    public GroupedOpenApi publicAPI(){
        return GroupedOpenApi.builder()
                .group("edition-public")
                .pathsToMatch("/api")
                .build();
    }*/
}