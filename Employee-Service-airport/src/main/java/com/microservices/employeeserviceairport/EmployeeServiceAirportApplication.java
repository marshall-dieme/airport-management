package com.microservices.employeeserviceairport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeServiceAirportApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceAirportApplication.class, args);
    }

}
