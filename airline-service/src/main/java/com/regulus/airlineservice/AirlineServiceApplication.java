package com.regulus.airlineservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirlineServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineServiceApplication.class, args);
    }

}
