package com.saraya.microservicerentals;

import com.saraya.microservicerentals.models.Rentals;
import com.saraya.microservicerentals.repositories.RentalsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class MicroservicerentalsApplication implements CommandLineRunner {
    private final RentalsRepository rentalsRepository;

    public MicroservicerentalsApplication(RentalsRepository rentalsRepository) {
        this.rentalsRepository = rentalsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroservicerentalsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.rentalsRepository.save(new Rentals(null, "my rentals", "toto@gmail.com",  "7477 855775", "licence_no", LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), "car_no", 60000));
        this.rentalsRepository.save(new Rentals(null, "my rentals", "toto@gmail.com", "7477 8555585", "licence_no", LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), "car_no", 60000));
        this.rentalsRepository.save(new Rentals(null, "my rentals", "toto@gmail.com",  "7477 80005", "licence_no", LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), "car_no", 60000));
        this.rentalsRepository.save(new Rentals(null, "my rentals", "toto@gmail.com", "7477 845685", "licence_no", LocalDate.now(), LocalTime.now(), LocalDate.now(), LocalTime.now(), "car_no", 60000));
    }
}
