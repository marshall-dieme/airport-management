package com.saraya.apigatewayy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayyApplication.class, args);
	}

}
