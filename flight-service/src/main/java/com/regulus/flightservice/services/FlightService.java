package com.regulus.flightservice.services;

import com.regulus.flightservice.dtos.FlightDto;
import com.regulus.flightservice.models.Flight;
import com.regulus.flightservice.repositories.FlightRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FlightService {

    private final FlightRepository repository;

    private final Mapper mapper;

    public FlightService(FlightRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Flight> getFlight(){
        return repository.findAll();
    }

    public FlightDto getFlight(int id){
        Flight flight =  repository.findById(id).get();
        return mapper.toDto(flight);
    }

    public FlightDto createFlight(FlightDto flightDto){
        Flight flight = mapper.toEntity(flightDto);
        flight =  repository.save(flight);
        return mapper.toDto(flight);
    }

    public FlightDto updateFlight(FlightDto flightDto, int id){
        FlightDto flightDto1 = getFlight(id);
        Flight flight = mapper.toEntity(flightDto1);
        flight.setFlight_id(flightDto.getFlight_id());
        flight.setAirplane_type_id(flightDto.getAirplane_type_id());
        flight.setAirplane_type_identifier(flightDto.getAirplane_type_identifier());
        flight.setDescription(flightDto.getDescription());
        flight = repository.save(flight);
        return mapper.toDto(flight);
    }

    public void deleteFlight(int id){
        FlightDto flightDto = getFlight(id);
        Flight flight = mapper.toEntity(flightDto);
        repository.delete(flight);
    }

    public Integer getFlightId(String identifier) {
        return repository.findByAirplane_type_identifier(identifier);
    }
}
