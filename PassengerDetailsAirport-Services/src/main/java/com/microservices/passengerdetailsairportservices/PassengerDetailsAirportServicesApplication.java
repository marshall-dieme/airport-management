package com.microservices.passengerdetailsairportservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class PassengerDetailsAirportServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassengerDetailsAirportServicesApplication.class, args);
    }

}
