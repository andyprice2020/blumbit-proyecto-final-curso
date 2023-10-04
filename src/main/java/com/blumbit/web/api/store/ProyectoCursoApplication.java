package com.blumbit.web.api.store;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blumbit Online Store", version = "1.0.0", description = "API REST for Blumbit Online Store Application v1.0.0"))
public class ProyectoCursoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoCursoApplication.class, args);
    }

}
