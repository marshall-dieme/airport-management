package com.regulus.flightservice.services;

import com.regulus.flightservice.dtos.FlightDto;
import com.regulus.flightservice.models.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public FlightDto toDto(Flight flight){
        FlightDto dto = new FlightDto();
        dto.setFlight_id(flight.getFlight_id());
        dto.setFlight_no(flight.getFlight_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dto.setDeparture_date(flight.getDeparture_date().format(formatter));
        dto.setArrival_date(flight.getArrival_date().format(formatter));
        dto.setFrom_to(flight.getFrom_to());
        dto.setBooking_id(flight.getBooking_id());
        return dto;
    }

    public Flight toEntity(FlightDto dto){
        Flight flight = new Flight();
        flight.setFlight_id(dto.getFlight_id());
        flight.setFlight_no(dto.getFlight_no());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flight.setDeparture_date(LocalDate.parse(dto.getDeparture_date(), formatter));
        flight.setArrival_date(LocalDate.parse(dto.getArrival_date(),formatter));
        flight.setFrom_to(dto.getFrom_to());
        flight.setBooking_id(dto.getBooking_id());
        return flight;
    }

}
