package com.saraya.registryserviceeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryServiceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryServiceEurekaApplication.class, args);
    }

}
