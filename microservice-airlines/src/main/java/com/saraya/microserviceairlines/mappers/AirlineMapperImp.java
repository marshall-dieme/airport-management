package com.saraya.microserviceairlines.mappers;

import com.saraya.microserviceairlines.dto.AirlineDto;
import com.saraya.microserviceairlines.models.Airline;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineMapperImp implements AirlineMapper{
    @Override
    public Airline airlineDtoToAirline(AirlineDto airlineDto) {
        Airline airline = new Airline();
        airline.setAirline_id(airlineDto.getAirline_id());
        airline.setAirplane_name(airlineDto.getAirplane_name());
        airline.setIata(airlineDto.getIata());
        return airline;
    }

    @Override
    public AirlineDto airlineToAirlineDto(Airline airline) {
        AirlineDto airlineDto = new AirlineDto();
        airline.setAirline_id(airline.getAirline_id());
        airline.setAirplane_name(airline.getAirplane_name());
        airline.setIata(airline.getIata());
        return airlineDto;
    }

    @Override
    public List<AirlineDto> airlinesToAirlineDtos(List<Airline> airlines) {
        List<AirlineDto> airlineDtos = new ArrayList<>();
        for (Airline airline:airlines
             ) {
            airlineDtos.add(airlineToAirlineDto(airline));
        }
        return airlineDtos;
    }

    @Override
    public Airline updateAirlineFromAirlineDto(AirlineDto airlineDto, Airline airline) {
        return null;
    }
}
