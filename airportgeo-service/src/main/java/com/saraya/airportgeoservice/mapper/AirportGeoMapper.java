package com.saraya.airportgeoservice.mapper;

import com.saraya.airportgeoservice.bean.AirportGeo;
import com.saraya.airportgeoservice.dto.AirportGeoDto;

public class AirportGeoMapper {
    public AirportGeo toEntity(AirportGeoDto dto){
        AirportGeo airportGeo = new AirportGeo();
        airportGeo.setAirportId(dto.getAirportGeoId());
        airportGeo.setAirportId(airportGeo.getAirportId());
        airportGeo.setCity(dto.getCity());
        airportGeo.setCountry(dto.getCountry());
        return airportGeo;
    }
}
