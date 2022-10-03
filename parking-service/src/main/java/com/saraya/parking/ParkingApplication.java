package com.saraya.parking;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableFeignClients
public class ParkingApplication {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, LocalDate> converter = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            }
        };
        modelMapper.addConverter(converter);
        Converter<String, LocalTime> localTimeConverter = new Converter<String, LocalTime>() {
            @Override
            public LocalTime convert(MappingContext<String, LocalTime> mappingContext) {
                return LocalTime.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("HH:mm:ss"));
            }
        };
        modelMapper.addConverter(localTimeConverter);
        return modelMapper;
    }



    public static void main(String[] args) {
        SpringApplication.run(ParkingApplication.class, args);
    }

}
