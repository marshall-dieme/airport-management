package com.regulus.airplanetypeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AirplaneTypeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirplaneTypeServiceApplication.class, args);
    }

}
