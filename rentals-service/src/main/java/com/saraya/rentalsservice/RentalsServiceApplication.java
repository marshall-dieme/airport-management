package com.saraya.rentalsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableDiscoveryClient
public class RentalsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalsServiceApplication.class, args);
	}


}
