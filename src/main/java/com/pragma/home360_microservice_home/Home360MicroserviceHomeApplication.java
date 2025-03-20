package com.pragma.home360_microservice_home;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Home360MicroserviceHomeApplication {

    public static void main(String[] args) {
        // Cargar las variables de entorno desde el archivo .env
        Dotenv dotenv = Dotenv.load();

        // Establecer las variables de entorno en el entorno de la JVM
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(Home360MicroserviceHomeApplication.class, args);
    }

}