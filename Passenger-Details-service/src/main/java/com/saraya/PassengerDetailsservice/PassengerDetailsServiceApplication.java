package com.saraya.PassengerDetailsservice;

import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PassengerDetailsServiceApplication {

	@Bean
	public ModelMapper mapper() {
		ModelMapper mapper = new ModelMapper();
		Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
			@Override
			public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
				return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			}
		};
		mapper.addConverter(localDateConverter);
		return mapper;

	}

	public static void main(String[] args) {
		SpringApplication.run(PassengerDetailsServiceApplication.class, args);
	}

}
