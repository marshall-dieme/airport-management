package com.saraya.airplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.saraya.airplan.model5")

public class AirlplaneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlplaneApplication.class, args);
	}

}
