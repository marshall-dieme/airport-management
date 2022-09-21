package com.saraya.airplaneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AirplaneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirplaneServiceApplication.class, args);
	}

}
