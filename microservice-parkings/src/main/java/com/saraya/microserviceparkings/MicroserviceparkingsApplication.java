package com.saraya.microserviceparkings;

import com.saraya.microserviceparkings.models.Parking;
import com.saraya.microserviceparkings.repositories.ParkingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceparkingsApplication implements CommandLineRunner {
    private final ParkingRepository parkingRepository;

    public MicroserviceparkingsApplication(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceparkingsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.parkingRepository.save(new Parking(null,"park1","omm@gmail.com", "775262401",LocalDate.now(), LocalTime.now(),LocalDate.now(),LocalTime.now(),"rop",77000));
        this.parkingRepository.save(new Parking(null,"park1","omm@gmail.com", "775262401",LocalDate.now(), LocalTime.now(),LocalDate.now(),LocalTime.now(),"rop",4200));
        this.parkingRepository.save(new Parking(null,"park1","omm@gmail.com", "775262401",LocalDate.now(), LocalTime.now(),LocalDate.now(),LocalTime.now(),"rop",4500000));
    }
}
