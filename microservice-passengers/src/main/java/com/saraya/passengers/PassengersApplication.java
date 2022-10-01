package com.saraya.passengers;

import com.saraya.passengers.models.Passenger;
import com.saraya.passengers.repositories.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PassengersApplication implements CommandLineRunner {
    private PassengerRepository passengerRepository;

    public PassengersApplication(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PassengersApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.passengerRepository.save(new Passenger(null,"no","ibarahim","Saandati"));
        this.passengerRepository.save(new Passenger(null,"pai","Hassane","OMAR"));
        this.passengerRepository.save(new Passenger(null,"nb","ibarahim","Salim"));
        this.passengerRepository.save(new Passenger(null,"ppno","Ali","Moumar"));
        this.passengerRepository.save(new Passenger(null,"no","FALL","OMAR"));
    }
}
