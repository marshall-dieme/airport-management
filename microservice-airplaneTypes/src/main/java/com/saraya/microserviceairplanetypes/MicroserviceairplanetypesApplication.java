package com.saraya.microserviceairplanetypes;

import com.saraya.microserviceairplanetypes.models.AirplaneType;
import com.saraya.microserviceairplanetypes.repositories.AirplaneTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceairplanetypesApplication implements CommandLineRunner {
    private final AirplaneTypeRepository airplaneTypeRepository;

    public MicroserviceairplanetypesApplication(AirplaneTypeRepository airplaneTypeRepository) {
        this.airplaneTypeRepository = airplaneTypeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceairplanetypesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.airplaneTypeRepository.save(new AirplaneType(null,"II4","AirplaneType1"));
        this.airplaneTypeRepository.save(new AirplaneType(null,"II012","AirplaneType2"));
        this.airplaneTypeRepository.save(new AirplaneType(null,"II45","AirplaneType3"));
        this.airplaneTypeRepository.save(new AirplaneType(null,"II4778","AirplaneType4"));

    }
}
