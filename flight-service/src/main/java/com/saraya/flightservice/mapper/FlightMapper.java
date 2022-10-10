package com.saraya.flightservice.mapper;

import com.saraya.flightservice.bean.Flight;
import com.saraya.flightservice.dto.FlightDto;

public class FlightMapper {
    public Flight toEntity(FlightDto dto) {
        Flight flight = new Flight();
        flight.setFlightNo(dto.getFlightNo());
        flight.setFrom(dto.getFrom());
        return flight;
    }
}
