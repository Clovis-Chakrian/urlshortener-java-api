package br.com.clovischakrian.urlshortener.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(
        contact = @Contact(name = "Urlshortener"),
        title = "Urlshortener",
        version = "0.0.1"))
@Configuration
public class OpenApiConfig {
}
