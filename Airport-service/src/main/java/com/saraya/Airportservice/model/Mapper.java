package com.saraya.Airportservice.model;

import com.saraya.Airportservice.dto.AirportDto;
import org.springframework.stereotype.Service;

@Service
public class Mapper {


    public Airport convertToEntity(AirportDto dto) {
        Airport airport = new Airport();
        airport.setAirport_id(dto.getAirport_id());
        airport.setIata(dto.getIata());
        airport.setIcao(dto.getIcao());
        airport.setAirport_name(dto.getAirport_name());
        airport.setAirport_geo_id(dto.getAirport_geo_id());
        airport.setServices_id(dto.getServices_id());
        airport.setAirline_id(dto.getAirline_id());
        return airport;
    }

    public AirportDto convertToDto(Airport airport) {
        AirportDto dto = new AirportDto();
        dto.setAirport_id(airport.getAirport_id());
        dto.setAirline_id(airport.getAirline_id());
        dto.setAirport_geo_id(airport.getAirport_geo_id());
        dto.setServices_id(airport.getServices_id());
        dto.setIata(airport.getIata());
        dto.setIcao(airport.getIcao());
        dto.setAirport_name(airport.getAirport_name());
        return dto;
    }
}
