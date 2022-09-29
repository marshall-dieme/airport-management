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
        dto.setAirplane_id(airline.getAirplane_id());
        return dto;
    }

    public Airline toEntity(AirlineDto dto){
        Airline airline = new Airline();
        airline.setAirline_id(dto.getAirline_id());
        airline.setAirline_name(dto.getAirline_name());
        airline.setIata(dto.getIata());
        airline.setAirplane_id(dto.getAirplane_id());
        return airline;
    }
}
