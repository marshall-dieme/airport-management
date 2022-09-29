package com.regulus.airlineservice.services;

import com.regulus.airlineservice.dtos.AirlineDto;
import com.regulus.airlineservice.models.Airline;
import org.springframework.stereotype.Service;


@Service
public class Mapper {

    public AirlineDto toDto(Airline airline){
        AirlineDto dto = new AirlineDto();
        dto.setAirline_id(airline.getAirline_id());
        dto.setAirline_name(airline.getAirline_name());
        dto.setIata(airline.getIata());
        dto.setAirport_id(airline.getAirport_id());
        return dto;
    }

    public Airline toEntity(AirlineDto dto){
        Airline airline = new Airline();
        airline.setAirline_id(dto.getAirline_id());
        airline.setAirline_name(dto.getAirline_name());
        airline.setIata(dto.getIata());
        airline.setAirport_id(dto.getAirport_id());
        return airline;
    }
}
