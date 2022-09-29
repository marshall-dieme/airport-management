package com.regulus.airportservice.services;

import com.regulus.airportservice.Dtos.AirportDto;
import com.regulus.airportservice.models.Airport;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public AirportDto toDto(Airport airport){
        AirportDto dto = new AirportDto();
        dto.setAirport_id(airport.getAirport_id());
        dto.setIata(airport.getIata());
        dto.setIcao(airport.getIcao());
        dto.setAirport_name(airport.getAirport_name());
        return dto;
    }

    public Airport toEntity(AirportDto airportDto){
        Airport airport = new Airport();
        airport.setAirport_id(airportDto.getAirport_id());
        airport.setIata(airportDto.getIata());
        airport.setIcao(airportDto.getIcao());
        airport.setAirport_name(airportDto.getAirport_name());
        return airport;
    }

}
