package com.ranjan.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SabitaCloudKitchenBackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SabitaCloudKitchenBackServiceApplication.class, args);
	}

}
