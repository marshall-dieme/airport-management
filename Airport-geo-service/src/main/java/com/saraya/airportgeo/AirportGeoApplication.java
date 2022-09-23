package com.saraya.airportgeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AirportGeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportGeoApplication.class, args);
	}

}
