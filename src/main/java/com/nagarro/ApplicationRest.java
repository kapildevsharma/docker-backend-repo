package com.nagarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;

@SpringBootApplication
public class ApplicationRest {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRest.class, args);
    }

    /**
     *
     * SpringDoc OpenAPI configuration
     * Replaces old Springfox Swagger 2 configuration.
     * http://localhost:8383/swagger-ui.html#!/book459545author45controller/saveAuthorUsingPOST
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Application REST API")
                        .version("1.0.0")
                        .description("API documentation for Application REST Backend")
                        .contact(new Contact()
                                .name("Kapil Team")
                                .email("kapilgyanvihar@gmail.com")));
    }
}