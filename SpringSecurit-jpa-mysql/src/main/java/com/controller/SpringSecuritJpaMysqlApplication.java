package com.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SpringSecuritJpaMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecuritJpaMysqlApplication.class, args);
	}

}
