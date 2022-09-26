package com.geo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.geo.model4")

public class Airport_GeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Airport_GeoApplication.class, args);
	}

}
