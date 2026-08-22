package todo_api_java.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI todoApiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("To-Do API Java")
                        .description("API REST para gerenciamento de tarefas, construída com Spring Boot")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Jamylle Santana")
                                .url("https://github.com/jsantana-dev")));
    }
}

/*
@Configuration marca essa classe como fonte de configuração da api
objeto OpenAPI é só um metadado
 */