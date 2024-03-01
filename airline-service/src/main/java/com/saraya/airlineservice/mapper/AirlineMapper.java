package com.saraya.airlineservice.mapper;

import com.saraya.airlineservice.bean.Airline;
import com.saraya.airlineservice.dto.AirlineDto;

public class AirlineMapper {
    public Airline toEntity(AirlineDto dto) {
        Airline airline = new Airline();
        airline.setAirlineName(dto.getAirlineName());
        airline.setIata(dto.isIata());
        return airline;
    }
}
