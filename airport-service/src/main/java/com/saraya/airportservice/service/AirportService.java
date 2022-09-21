package com.saraya.airportservice.service;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.repo.AirportRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepo repo;

    public AirportService(AirportRepo repo) {
        this.repo = repo;
    }

    public List<Airport> getAll(){
        return repo.findAll();
    }

    public Optional<Airport> getById(String id){
        return repo.findById(id);
    }

    public Airport create(Airport airport){
        airport.generedId();
        return repo.save(airport);
    }

    public Airport update(Airport airportGeo){
        return repo.save(airportGeo);
    }

    public void delete(String id){
        repo.deleteById(id);
    }
}
