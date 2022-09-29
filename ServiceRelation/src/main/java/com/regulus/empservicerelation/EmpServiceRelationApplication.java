package com.regulus.empservicerelation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmpServiceRelationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpServiceRelationApplication.class, args);
    }

}
