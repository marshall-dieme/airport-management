package com.regulus.airlineservice.services;

import com.regulus.airlineservice.dtos.AirlineDto;
import com.regulus.airlineservice.models.Airline;
import com.regulus.airlineservice.repositories.AirlineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AirlineService {

    private final RestTemplate restTemplate;
    private final AirlineRepository repository;

    private final Mapper mapper;

    public AirlineService(RestTemplate restTemplate, AirlineRepository repository, Mapper mapper) {
        this.restTemplate = restTemplate;
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Airline> getAirline(){
        return repository.findAll();
    }

    public AirlineDto getAirline(int id){
        Airline airline =  repository.findById(id).get();
        return mapper.toDto(airline);
    }

    public AirlineDto createAirline(AirlineDto airlineDto){
        Integer airport_id = restTemplate.getForEntity("http://airport-service/airport/name/" + airlineDto.getAirport_name(),
                Integer.class)
                .getBody();
        assert airport_id != null;
        airlineDto.setAirport_id(airport_id);
        Airline airline = mapper.toEntity(airlineDto);
        airline =  repository.save(airline);
        return mapper.toDto(airline);
    }

    public AirlineDto updateAirline(AirlineDto airlineDto, int id){
        AirlineDto airlineDto1 = getAirline(id);
        Airline airline = mapper.toEntity(airlineDto1);
        airline.setAirline_name(airlineDto.getAirline_name());
        airline.setIata(airline.getIata());
        airline.setAirport_id(airlineDto.getAirport_id());
        airline = repository.save(airline);
        return mapper.toDto(airline);
    }

    public void deleteAirline(int id){
        AirlineDto airlineDto = getAirline(id);
        Airline airline = mapper.toEntity(airlineDto);
        repository.delete(airline);
    }

    public Integer getAirlineId(String name) {
        return repository.findByAirline_name(name);
    }
}
