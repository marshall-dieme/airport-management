package com.regulus.airportgeoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirportGeoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirportGeoServiceApplication.class, args);
    }

}
