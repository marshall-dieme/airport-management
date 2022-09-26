package com.saraya.airplaneservice;

import com.saraya.airplaneservice.models.Airplane;
import com.saraya.airplaneservice.repositories.AirplaneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AirplaneServiceApplication implements CommandLineRunner {
    private final AirplaneRepository airplaneRepository;

    public AirplaneServiceApplication(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(AirplaneServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.airplaneRepository.save(new Airplane(null,25));
        this.airplaneRepository.save(new Airplane(null,251));
        this.airplaneRepository.save(new Airplane(null,21));
        this.airplaneRepository.save(new Airplane(null,125));
        this.airplaneRepository.save(new Airplane(null,825));
        this.airplaneRepository.save(new Airplane(null,925));
        this.airplaneRepository.save(new Airplane(null,525));
    }
}
