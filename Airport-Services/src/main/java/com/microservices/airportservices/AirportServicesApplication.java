package com.microservices.airportservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AirportServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirportServicesApplication.class, args);
    }

}
