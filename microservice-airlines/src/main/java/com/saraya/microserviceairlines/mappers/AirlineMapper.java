package com.saraya.microserviceairlines.mappers;

import com.saraya.microserviceairlines.dto.AirlineDto;
import com.saraya.microserviceairlines.models.Airline;

import java.util.List;

public interface AirlineMapper {
    Airline airlineDtoToAirline(AirlineDto airlineDto);

    AirlineDto airlineToAirlineDto(Airline airline);

    List<AirlineDto> airlinesToAirlineDtos(List<Airline> airlines);

    Airline updateAirlineFromAirlineDto(AirlineDto airlineDto,  Airline airline);
}
