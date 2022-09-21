package com.saraya.servicesservice;

import com.saraya.servicesservice.models.Services;
import com.saraya.servicesservice.repositories.ServicesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicesServiceApplication implements CommandLineRunner {
    private final ServicesRepository servicesRepository;

    public ServicesServiceApplication(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServicesServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.servicesRepository.save(new Services(null,"Service1"));
        this.servicesRepository.save(new Services(null,"Service2"));
        this.servicesRepository.save(new Services(null,"Service3"));
        this.servicesRepository.save(new Services(null,"Service4"));
        this.servicesRepository.save(new Services(null,"Service5"));
      
    }
}
