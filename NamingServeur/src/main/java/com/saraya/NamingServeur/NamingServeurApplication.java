package com.saraya.NamingServeur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NamingServeurApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingServeurApplication.class, args);
	}

}
