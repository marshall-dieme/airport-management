package com.saraya.airportservice.mapper;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.dto.AirportDto;
import org.springframework.stereotype.Service;

@Service
public class AirportMapper {

    public Airport toEntity(AirportDto dto){
        Airport airport = new Airport();
        airport.setAirportId(dto.getAirportId());
        airport.setIata(dto.isIata());
        airport.setIcao(dto.isIcao());
        airport.setAirportGeoId(dto.getAirportGeoId());
        airport.setName(dto.getName());
        return airport;
    }

}
