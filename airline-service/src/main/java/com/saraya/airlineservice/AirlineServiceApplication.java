package com.saraya.airlineservice;

import com.saraya.airlineservice.models.Airline;
import com.saraya.airlineservice.repositories.AirlineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirlineServiceApplication implements CommandLineRunner {
    private final AirlineRepository airlineRepository;

    public AirlineServiceApplication(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AirlineServiceApplication.class, args);
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
