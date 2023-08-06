package com.you.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

//General API Information (swagger has already working after adding dependencies in pom.xml)
/*
* 
*/

@SpringBootApplication

@OpenAPIDefinition(
		info = @Info(
				  title = "Springboot REST API Documentation",
				  description = "Springboot REST API Documentation",
				  version = "v1.0",
				  contact = @Contact(
						     name = "Amit Kumar",
						     email = "Sahay.mtech2013@gmail.com",
						     url="https://www.amit.com"
						  ),
				  license = @License(
						      name="Apache 2.0",
						      url="https://www.amitkumar.com/licence"
						  )
				),
		  externalDocs = @ExternalDocumentation(
				    description = "Spring Boot User Managenment Documentation",
				    url="amit.com"
				  )
		)
   
public class RestApiTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiTutorialApplication.class, args);
	}

}
