package com.saraya.airportservice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class AirportServiceApplication {

	@Bean
	public ModelMapper getModel() {
	ModelMapper mapper = new ModelMapper();
	Converter<String , LocalDate> converter = mappingContext -> {
		return LocalDate.parse(mappingContext.getSource(),
				DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	};
	mapper.addConverter(converter);
	return mapper;
	}
	public static void main(String[] args) {
		AirportServiceApplication a = new AirportServiceApplication();
		a.getModel();
		SpringApplication.run(AirportServiceApplication.class, args);
	}

}
