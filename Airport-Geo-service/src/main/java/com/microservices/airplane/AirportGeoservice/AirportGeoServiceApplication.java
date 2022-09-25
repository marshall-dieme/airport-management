package com.microservices.airplane.AirportGeoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AirportGeoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportGeoServiceApplication.class, args);
	}

}
