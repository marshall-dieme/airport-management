package com.saraya.servicesservice;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicesServiceApplication {


	@Bean
	public ModelMapper getModel() {
	ModelMapper mapper = new ModelMapper();
	
		return mapper;
	
	}
	public static void main(String[] args) {
		ServicesServiceApplication service = new ServicesServiceApplication();
		service.getModel();
		SpringApplication.run(ServicesServiceApplication.class, args);
	}

}
