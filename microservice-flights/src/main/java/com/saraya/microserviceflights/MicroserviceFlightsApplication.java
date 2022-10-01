package com.saraya.microserviceflights;

import com.saraya.microserviceflights.models.Flight;
import com.saraya.microserviceflights.repositories.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MicroserviceFlightsApplication implements CommandLineRunner {
    private final FlightRepository flightRepository;

    public MicroserviceFlightsApplication(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceFlightsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.flightRepository.save(new Flight(null,"fl", LocalDate.now(),"Comoros","Senegal"));
        this.flightRepository.save(new Flight(null,"f2", LocalDate.now(),"Malie","Madagascar"));
        this.flightRepository.save(new Flight(null,"f3", LocalDate.now(),"Comoros","Senegal"));
    }
}
