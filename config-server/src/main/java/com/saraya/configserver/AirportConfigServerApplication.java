package com.saraya.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class AirportConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportConfigServerApplication.class, args);
	}

}
