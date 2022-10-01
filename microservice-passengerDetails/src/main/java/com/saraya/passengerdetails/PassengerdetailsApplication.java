package com.saraya.passengerdetails;

import com.saraya.passengerdetails.models.PassengerDetails;
import com.saraya.passengerdetails.repositories.PassengerDetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PassengerdetailsApplication implements CommandLineRunner {
    private final PassengerDetailsRepository passengerDetailsRepository;

    public PassengerdetailsApplication(PassengerDetailsRepository passengerDetailsRepository) {
        this.passengerDetailsRepository = passengerDetailsRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(PassengerdetailsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.passengerDetailsRepository.save(new PassengerDetails(null, LocalDate.now(),"M","street 55","fat4","Saint Louit","tpo","Senegal","ibra@gmail.com","778236334"));
        this.passengerDetailsRepository.save(new PassengerDetails(null, LocalDate.now(),"M","street 55","fat4","Saint Louit","tpo","Senegal","ibra@gmail.com","778236334"));
        this.passengerDetailsRepository.save(new PassengerDetails(null, LocalDate.now(),"M","street 55","fat4","Saint Louit","tpo","Senegal","ibra@gmail.com","778236334"));

    }
}
