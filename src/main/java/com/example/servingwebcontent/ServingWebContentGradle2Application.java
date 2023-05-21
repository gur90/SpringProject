package com.example.servingwebcontent;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServingWebContentGradle2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServingWebContentGradle2Application.class, args);
	}
@Bean
	public OpenAPI baseOpenApi(){

		return new OpenAPI().info(new Info().title("Ticket shop")
				.version("1.0.0")
				.description("Shop REST API")
				.contact(new Contact().name("Anna Rogozina").email("annettgur@gmail.com")));
}
}
