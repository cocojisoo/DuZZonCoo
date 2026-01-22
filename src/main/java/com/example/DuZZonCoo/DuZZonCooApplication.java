package com.example.DuZZonCoo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DuZZonCooApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuZZonCooApplication.class, args);
	}

}
