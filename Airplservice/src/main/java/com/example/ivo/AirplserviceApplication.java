package com.example.ivo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.ivo.modelcontr")

public class AirplserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirplserviceApplication.class, args);
	}

}
