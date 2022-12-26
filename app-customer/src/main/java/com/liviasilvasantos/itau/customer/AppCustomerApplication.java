package com.liviasilvasantos.itau.customer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Customers API",
				version = "1.0",
				description = "Customers Information",
				contact = @Contact(name = "Lívia Silva Santos")
		)
)
public class AppCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCustomerApplication.class, args);
	}

}
