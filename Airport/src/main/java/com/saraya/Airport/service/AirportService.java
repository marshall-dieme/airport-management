package com.saraya.Airport.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.saraya.Airport.dto.AirportAirlineDTO;
import com.saraya.Airport.dto.AirportServicesDTO;
import com.saraya.Airport.entity.Airport;
import com.saraya.Airport.repository.AirportRepository;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AirportService {
    
    private final AirportRepository  airportRepo;

    // private final ServicesRepo serviceRepo;

    // private final AirlineRepo airlineRepo;

    public List<AirportAirlineDTO> getAllAirportAirlines(){
        return airportRepo.findAll()
                .stream()
                .map(this::convertEntity1ToDto)
                .collect(Collectors.toList());

    }
    private AirportAirlineDTO convertEntity1ToDto(Airport airport){
        AirportAirlineDTO AAD = new AirportAirlineDTO();
        AAD.setAirport_id(airport.getAirport_id());
        AAD.setAirport_name(airport.getAirport_name());
        AAD.setIata(airport.getIata());
        return AAD;
       
    }

    public List<AirportServicesDTO> getAllAirportServices(){
        return airportRepo.findAll()
                .stream()
                .map(this::convertEntity2ToDto)
                .collect(Collectors.toList());

    }

    private AirportServicesDTO convertEntity2ToDto(Airport airport){
        AirportServicesDTO ASD = new AirportServicesDTO();
        ASD.setAirport_id(airport.getAirport_id());
        ASD.setAirport_name(airport.getAirport_name());
        return ASD;
       
    }
}