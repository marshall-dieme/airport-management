package com.saraya.airportservice;

import com.saraya.airportservice.models.Airport;
import com.saraya.airportservice.repositories.AirportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirportServiceApplication implements CommandLineRunner {
    private final AirportRepository airportRepository;

    public AirportServiceApplication(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AirportServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.airportRepository.save(new Airport(null,"Air force one","tom","AireForceOne1"));
        this.airportRepository.save(new Airport(null,"Air force one","tom","AireForceOne1"));
        this.airportRepository.save(new Airport(null,"Air force one","tom","AireForceOne1"));
        this.airportRepository.save(new Airport(null,"Air force one","tom","AireForceOne1"));
        this.airportRepository.save(new Airport(null,"Air force one","tom","AireForceOne1"));
        this.airportRepository.save(new Airport(null,"Air force one","tom","AireForceOne1"));
        this.airportRepository.save(new Airport(null,"Air force one","tom","AireForceOne1"));
    }
}
