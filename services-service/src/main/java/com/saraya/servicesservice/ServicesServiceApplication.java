package com.saraya.servicesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesServiceApplication.class, args);
	}

}
