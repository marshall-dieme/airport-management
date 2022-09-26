package com.saraya.airport.service;

import com.saraya.airport.model.Airport;
import com.saraya.airport.repo.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class ServiceAirport <AirportRepo> {

    @Autowired
    private final AirportRepository repo;

    public ServiceAirport(AirportRepository repo) {
        this.repo = repo;
    }
    public Optional<Airport> getById(Long id){
        return repo.findById(id);
    }
    public List<Airport> findAirport(){
        return repo.findAll();
    }

    public List<Airport> getAll() {
        return repo.findAll();
    }

    public Airport createAirport(Airport airport) {

        return repo.save(airport);

    }

    public Airport updateAirport(Airport airport) {
        return repo.save(airport);
    }
    public void deleteAirport(Long id){
        repo.deleteById(id);
    }
}
