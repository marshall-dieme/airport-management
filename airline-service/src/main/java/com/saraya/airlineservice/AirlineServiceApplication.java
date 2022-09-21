package com.saraya.airlineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AirlineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineServiceApplication.class, args);
	}

}
