package com.saraya.servicesservice;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getModel() {
		ModelMapper mapper = new ModelMapper();
		Converter<String, LocalDate> converter = mappingContext -> {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate date = LocalDate.parse(mappingContext.getSource(), format);
			return date;
		};
		mapper.addConverter(converter);
		return mapper;
	}
}
