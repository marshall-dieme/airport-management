package com.saraya.Employeeservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EmployeeServiceApplication {

 /*   @Bean
    public ModelMapper mapper() {
        ModelMapper modelMapper = new ModelMapper();
       *//* modelMapper.getConfiguration().setMatchingStrategy()*//*
        Converter<String, LocalDate> converter = mappingContext -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(mappingContext.getSource(), formatter);
        };
        modelMapper.addConverter(converter);
        return modelMapper;
    }*/

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}
