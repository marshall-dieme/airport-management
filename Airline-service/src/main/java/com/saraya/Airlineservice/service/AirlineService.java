package com.saraya.Airlineservice.service;

import com.saraya.Airlineservice.model.Airline;
import com.saraya.Airlineservice.repository.AirlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AirlineService {

    private final AirlineRepository repository;


    public List<Airline> getAllAirlines() {
        return repository.findAll();
    }

    public Airline getAirline(Long airline_id) {
        return repository.findById(airline_id).orElse(new Airline());


    }public Airline getAirlineByName(String airline_name) {
        return repository.getAirlineByAirline_name(airline_name);
    }

    public Airline saveAirline(Airline airline) {
        return repository.save(airline);
    }

    public Airline updateAirline(Airline airline) {
        return repository.save(airline);
    }

    public void deleteAirline(Long airline_id) {
        repository.deleteById(airline_id);
    }
}
