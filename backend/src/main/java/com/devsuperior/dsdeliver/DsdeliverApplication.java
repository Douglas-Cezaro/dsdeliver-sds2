package com.devsuperior.dsdeliver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class DsdeliverApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsdeliverApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("1") String appVersion) {
		return new OpenAPI().info(new Info().title("API DSDeliver").version(appVersion)
				.description("Api utilizada para a aplicação DSDeliver desenvolvido durante a semana DevSuperior 2.0")
				.termsOfService("http://google.com")
				.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				.contact(new Contact().name("Douglas Cezaro").url("https://github.com/Douglas-Cezaro")));

	}

}
