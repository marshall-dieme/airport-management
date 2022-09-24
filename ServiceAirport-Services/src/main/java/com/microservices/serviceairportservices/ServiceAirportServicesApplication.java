package com.microservices.serviceairportservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceAirportServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceAirportServicesApplication.class, args);
    }

}
