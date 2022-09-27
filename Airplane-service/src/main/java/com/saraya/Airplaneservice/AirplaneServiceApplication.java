package com.saraya.Airplaneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirplaneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirplaneServiceApplication.class, args);
	}

}
