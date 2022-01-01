package com.bafrow.contactbook;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Contact Book API", version = "1.0", description = "This is the API for a Contact book application. " +
        "This is a demonstration of SpringDoc OpenAPI library as part of a Spring boot application. It is largely configurable using the necessary annotations."),
        servers = {@Server(url = "https://localhost:8080/swagger-ui.html", description = "Local Dev Server")})
public class ContactBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactBookApplication.class, args);
    }

}
