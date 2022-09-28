package com.example.kheucha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients

@ComponentScan(basePackages="com.example.kheucha.model")
public class AirplEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirplEmployeeApplication.class, args);
	}

}
