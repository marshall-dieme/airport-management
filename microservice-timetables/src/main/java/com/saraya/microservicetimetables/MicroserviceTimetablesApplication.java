package com.saraya.microservicetimetables;

import com.saraya.microservicetimetables.models.TimeTable;
import com.saraya.microservicetimetables.repositories.TimeTableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceTimetablesApplication implements CommandLineRunner {
    private final TimeTableRepository timeTableRepository;

    public MicroserviceTimetablesApplication(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTimetablesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        this.timeTableRepository.save(new TimeTable(null,"China", "USA"," airline 441", "Direct"));
        this.timeTableRepository.save(new TimeTable(null,"Uk", "USA"," airline 441", "Direct"));
        this.timeTableRepository.save(new TimeTable(null,"Africa", "USA"," airline 441", "Direct"));
        this.timeTableRepository.save(new TimeTable(null,"Comoros", "USA"," airline 441", "Direct"));

    }
}
