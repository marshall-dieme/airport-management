package com.microservices.airlineairportservices.service;


import com.microservices.airlineairportservices.entity.Airline;
import com.microservices.airlineairportservices.entity.AirlineDTO;
import com.microservices.airlineairportservices.repository.AirlineRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepo repo;

    public AirlineService(AirlineRepo repo) {
        this.repo = repo;
    }

    public List<Airline> getAll(){
        return repo.findAll();
    }

    public Optional<Airline> getById(Long airline_id) {
        return repo.findById(airline_id);
    }

    public Airline create(AirlineDTO dto) {
        Airline airline = new Airline();
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airportName", dto.getAirportName());
        String idAirport = template.getForEntity(
                        "http://localhost:8001/airp/airportName/{airportName}",
                        String.class,
                        urlValues)
                .getBody();
        changeToModel(dto, airline);
        airline.setIdAirport(idAirport);
        return repo.save(airline);
    }

    public Airline update(AirlineDTO dto) {
        Airline airline = new Airline();
        airline.setAirline_id(dto.getAirline_id());
        changeToModel(dto, airline);
        return repo.save(airline);
    }

    private static void changeToModel(AirlineDTO dto, Airline airline) {
        airline.setAirlineName(dto.getAirlineName());
        airline.setIata(dto.getIata());

    }

    public void delete(Long airline_id) {
        repo.deleteById(airline_id);
    }

    public List<Airline> findAirportByAirline(String airportName){
        RestTemplate template = new RestTemplate();
        Map<String, String> urlValues = new HashMap<>();
        urlValues.put("airportName", airportName);
        String idAirport = template.getForEntity(
                        "http://localhost:8001/airp/airportName/{airportName}",
                        String.class,
                        urlValues)
                .getBody();

        return (List<Airline>)
                repo.findByIdAirport(idAirport);
    }

    public String getIdAirline(String airlineName ) {
        return repo.getByIdAirline(airlineName);
    }
}
