package com.saraya.Airportservice.model;

import com.saraya.Airportservice.dto.AirportDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class Mapper {

    private final ModelMapper modelMapper;

    public Airport convertToEntity(AirportDto dto) {
        Airport airport = new Airport();
        airport.setAirport_id(dto.getAirport_id());
        airport.setIata(dto.getIata());
        airport.setIcao(dto.getIcao());
        airport.setAirport_name(dto.getAirport_name());
        airport.setAirport_geo_id(dto.getAirport_id());
        airport.setService_id(dto.getAirport_id());
        airport.setAirline_id(dto.getAirport_id());
        /*modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);*/
        /*modelMapper.map(dto, Airport.class)*/
        return airport;
    }

    public AirportDto convertToDto(Airport airport) {
        AirportDto dto = new AirportDto();
        dto.setAirport_id(airport.getAirport_id());
        dto.setIata(airport.getIata());
        dto.setIcao(airport.getIcao());
        dto.setAirport_name(airport.getAirport_name());
       /* modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
        modelMapper.map(airport, AirportDto.class);*/
        return dto;
    }
}
