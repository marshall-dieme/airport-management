package com.example.airlineservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirlineServiceApplication {

	@Bean
	ModelMapper modelmapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(AirlineServiceApplication.class, args);
	}

}
