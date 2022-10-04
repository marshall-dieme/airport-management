package com.saraya.microservicebookings;

import com.saraya.microservicebookings.models.Booking;
import com.saraya.microservicebookings.repositories.BookingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceBookingsApplication implements CommandLineRunner {
    private final BookingRepository bookingRepository;

    public MicroserviceBookingsApplication(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBookingsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.bookingRepository.save(new Booking(null,"seat1",890));
        this.bookingRepository.save(new Booking(null,"seat3",5000011));
        this.bookingRepository.save(new Booking(null,"seat4",57700));
        this.bookingRepository.save(new Booking(null,"seat8",10000));


    }
}
