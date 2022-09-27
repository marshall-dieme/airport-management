package com.saraya.Airplane_Typeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AirplaneTypeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirplaneTypeServiceApplication.class, args);
	}

}
