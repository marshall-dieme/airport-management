package com.regulus.airportgeoservice.services;

import com.regulus.airportgeoservice.DTO.AirportGeoDto;
import com.regulus.airportgeoservice.models.AirportGeo;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    public AirportGeoDto toDto(AirportGeo airportGeo){
        AirportGeoDto dto = new AirportGeoDto();
        dto.setAirport_geo_id(airportGeo.getAirport_geo_id());
        dto.setCity(airportGeo.getCity());
        dto.setCountry(airportGeo.getCountry());
        return dto;
    }

    public AirportGeo toEntity(AirportGeoDto airportGeoDto){
        AirportGeo airportGeo = new AirportGeo();
        airportGeo.setAirport_geo_id(airportGeoDto.getAirport_geo_id());
        airportGeo.setCountry(airportGeoDto.getCountry());
        airportGeo.setCity(airportGeoDto.getCity());
        return airportGeo;
    }

}
