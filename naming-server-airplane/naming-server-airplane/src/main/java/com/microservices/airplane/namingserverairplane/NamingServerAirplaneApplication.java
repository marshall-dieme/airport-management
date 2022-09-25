package com.microservices.airplane.namingserverairplane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingServerAirplaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingServerAirplaneApplication.class, args);
	}

}
