package com.saraya.flight.service;


import com.saraya.flight.dto.FlightDto;
import com.saraya.flight.mapper.FlightMapper;
import com.saraya.flight.model.Flight;
import com.saraya.flight.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    @Autowired
    private FlightMapper mapper;

    public FlightDto saveFlight(FlightDto flightDto){
        Flight flight = mapper.toEntity(flightDto);
        flight = repository.save(flight);
        return mapper.toDto(flight);
    }

    public List<Flight> findAllFlight(){
        return repository.findAll();
    }

    public FlightDto getFlightById(long flight_id){
        Flight flight = repository.findById(flight_id);
        return mapper.toDto(flight);
    }

    public FlightDto update(FlightDto flightDto, long flight_id){
        FlightDto flightDto1 = getFlightById(flight_id);
        Flight flight = mapper.toEntity(flightDto1);
        flight.setFlight_id(flightDto.getFlight_id());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flight.setArrival_date(String.valueOf(LocalDate.parse(flight.getArrival_date().format(String.valueOf(formatter)))));
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        flight.setDeparture_date(String.valueOf(LocalDate.parse(flight.getDeparture_date().format(String.valueOf(formater)))));
        flight.setFrom(flightDto.getFrom());
        flight.setTo(flightDto.getTo());
        return mapper.toDto(flight);
    }

    public void deleteById(long flight_id){
        FlightDto flightDto = getFlightById(flight_id);
        Flight flight = mapper.toEntity(flightDto);
        repository.delete(flight);
    }


}
