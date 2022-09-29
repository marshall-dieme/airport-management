package com.saraya.flight.mapper;

import com.saraya.flight.dto.FlightDto;
import com.saraya.flight.model.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class FlightMapper{

    public Flight toEntity(FlightDto dto){
        Flight flight = new Flight();
        flight.setFlight_id(dto.getFlight_id());
        flight.setFlight_no(dto.getFlight_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flight.setArrival_date(String.valueOf(LocalDate.parse(String.valueOf(formatter))));
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flight.setDeparture_date(String.valueOf(LocalDate.parse(String.valueOf(form))));
        flight.setFrom(dto.getFrom());
        flight.setTo(dto.getTo());
        return flight;

    }

    public FlightDto toDto(Flight entity){
        FlightDto flightDto = new FlightDto();
        flightDto.setFlight_id(entity.getFlight_id());
        flightDto.setFlight_no(entity.getFlight_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flightDto.setArrival_date(String.valueOf(LocalDate.parse(flightDto.getArrival_date().format(String.valueOf(formatter)))));
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flightDto.setDeparture_date(String.valueOf(LocalDate.parse(flightDto.getDeparture_date().format(String.valueOf(formater)))));
        flightDto.setFrom(entity.getFrom());
        flightDto.setTo(entity.getTo());
        return flightDto;

    }

}
