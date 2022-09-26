package com.saraya.passagerdetailsservice;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableDiscoveryClient
public class PassagerDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassagerDetailsServiceApplication.class, args);
	}

	@Bean
	public ModelMapper getModel() {
		ModelMapper mapper = new ModelMapper();
		Converter<String, LocalDate> converter = new Converter<String, LocalDate>() {
			@Override
			public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
				return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			}
		};

		mapper.addConverter(converter);
		return mapper;
	}
}
