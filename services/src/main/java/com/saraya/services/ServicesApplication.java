package com.saraya.services;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ServicesApplication {

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	RestTemplate template() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(ServicesApplication.class, args);
	}

}
