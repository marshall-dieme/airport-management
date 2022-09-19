package com.microservices.airplane.configserverairplane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerAirplaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerAirplaneApplication.class, args);
	}

}
