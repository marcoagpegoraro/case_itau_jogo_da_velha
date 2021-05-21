package com.magpegoraro.itau.case_jogo_da_velha.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Jogo da velha")
                .description("\"Case de jogo da velha proposto.\"")
                .version("1.0.0")
                .license("")
                .licenseUrl("")
                .contact(new Contact("Marco Antonio Gonçalves Pegoraro", "https://www.linkedin.com/in/marco-antonio-goncalves", "marco.ag.pegoraro@hotmail.com"))
                .build();
    }
}
