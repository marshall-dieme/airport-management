package com.saraya.microserviceairlines;

import com.saraya.microserviceairlines.models.Airline;
import com.saraya.microserviceairlines.repositories.AirlineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAirlinesApplication implements CommandLineRunner {
    private final AirlineRepository airlineRepository;

    public MicroserviceAirlinesApplication(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAirlinesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.airlineRepository.save(new Airline(null,"airpline1","fop"));
        this.airlineRepository.save(new Airline(null,"airpline2","fop"));
        this.airlineRepository.save(new Airline(null,"airpline3","fop"));
        this.airlineRepository.save(new Airline(null,"airpline4","fop"));
        this.airlineRepository.save(new Airline(null,"airpline5","fop"));
        this.airlineRepository.save(new Airline(null,"airpline6","fop"));
        this.airlineRepository.save(new Airline(null,"airpline7","fop"));
        this.airlineRepository.save(new Airline(null,"airpline8","fop"));
    }
}
