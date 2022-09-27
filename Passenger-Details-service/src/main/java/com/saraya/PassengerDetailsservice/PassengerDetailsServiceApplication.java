package com.saraya.PassengerDetailsservice;

import com.saraya.PassengerDetailsservice.enums.Gender;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableEurekaClient
public class PassengerDetailsServiceApplication {

/*
	@Bean
	public ModelMapper mapper() {
		ModelMapper mapper = new ModelMapper();
		Converter<String, LocalDate> localDateConverter = mappingContext -> LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		mapper.addConverter(localDateConverter);
		return mapper;

	}
*/

	public static void main(String[] args) {
		SpringApplication.run(PassengerDetailsServiceApplication.class, args);
	}

}
