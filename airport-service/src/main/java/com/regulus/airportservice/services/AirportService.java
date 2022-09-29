package com.regulus.airportservice.services;

import com.regulus.airportservice.Dtos.AirportDto;
import com.regulus.airportservice.models.Airport;
import com.regulus.airportservice.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirportService {


    private final AirportRepository repository;

    @Autowired
    RestTemplate restTemplate;
    private final Mapper mapper;

    public AirportService(AirportRepository repository, Mapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Airport> getAirport(){
        return repository.findAll();
    }

    public AirportDto getAirport(int id){
        Airport airport =  repository.findById(id).get();
        return mapper.toDto(airport);
    }

    public AirportDto createAirport(AirportDto airportDto){
        Airport airport = mapper.toEntity(airportDto);
         airport =  repository.save(airport);
         return mapper.toDto(airport);
    }


    public AirportDto updateAirport(AirportDto airportDto, int id){
        AirportDto airportDto1 = getAirport(id);
        Airport airport = mapper.toEntity(airportDto1);
        airport.setIata(airportDto.getIata());
        airport.setIcao(airportDto.getIcao());
        airport.setAirport_name(airportDto.getAirport_name());
        airport = repository.save(airport);
        return mapper.toDto(airport);
    }

    public void deleteAirport(int id){
        AirportDto airportDto = getAirport(id);
        Airport airport = mapper.toEntity(airportDto);
        repository.delete(airport);
    }
}
