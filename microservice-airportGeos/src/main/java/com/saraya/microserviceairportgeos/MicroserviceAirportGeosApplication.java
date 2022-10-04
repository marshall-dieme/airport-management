package com.saraya.microserviceairportgeos;

import com.saraya.microserviceairportgeos.models.AirportGeo;
import com.saraya.microserviceairportgeos.repositories.AirportGeoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceAirportGeosApplication implements CommandLineRunner {

    private final AirportGeoRepository airportGeoRepository;

    public MicroserviceAirportGeosApplication(AirportGeoRepository airportGeoRepository) {
        this.airportGeoRepository = airportGeoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceAirportGeosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.airportGeoRepository.save(new AirportGeo(null,"Senegal","Dakar"));
            this.airportGeoRepository.save(new AirportGeo(null,"Comoros","Moroni"));
    }
}
