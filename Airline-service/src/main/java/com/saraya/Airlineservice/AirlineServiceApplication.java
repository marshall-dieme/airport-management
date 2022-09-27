package com.saraya.Airlineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AirlineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineServiceApplication.class, args);
	}

}
