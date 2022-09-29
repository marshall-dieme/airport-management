package com.saraya.microserviceservices;

import com.saraya.microserviceservices.models.Services;
import com.saraya.microserviceservices.repositories.ServicesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceServicesApplication implements CommandLineRunner {

    private final ServicesRepository servicesRepository;

    public MicroserviceServicesApplication(ServicesRepository servicesRepository){
        this.servicesRepository = servicesRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceServicesApplication.class, args);
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
