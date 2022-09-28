package com.saraya.passengerdetais;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mapping.context.MappingContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class PassengerDetaisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PassengerDetaisApplication.class, args);
    }

    @Bean
    public ModelMapper getModel() {
        ModelMapper mapper = new ModelMapper();
        Converter<String, LocalDate> converter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(org.modelmapper.spi.MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };

        mapper.addConverter(converter);
        return mapper;
    }
}
