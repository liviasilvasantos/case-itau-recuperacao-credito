package com.liviasilvasantos.itau.catalog;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Catalogs API",
				version = "1.0",
				description = "Catalogs Information",
				contact = @Contact(name = "Lívia Silva Santos")
		)
)
public class AppCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCatalogApplication.class, args);
	}

}
