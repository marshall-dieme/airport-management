package com.regulus.passengerdetailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PassengerDetailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassengerDetailServiceApplication.class, args);
    }

}
