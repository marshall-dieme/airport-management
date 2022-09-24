package com.microservices.airplaneairportservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class AirplaneAirportServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirplaneAirportServicesApplication.class, args);
    }

}
