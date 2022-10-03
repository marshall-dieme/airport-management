package com.saraya.microserviceairports;

import com.saraya.microserviceairports.models.Airport;
import com.saraya.microserviceairports.repositories.AirportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceAirportsApplication implements CommandLineRunner {
    private final AirportRepository airportRepository;

    public MicroserviceAirportsApplication(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAirportsApplication.class, args);
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
