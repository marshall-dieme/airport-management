package com.saraya.airport.service;

import com.saraya.airport.model.Airport;
import com.saraya.airport.repository.AirportRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Airportservice extends com.saraya.airport.model.Airport {
    private final AirportRepo repo;

    public Airportservice(AirportRepo repo) {
        this.repo = repo;
    }

    public List<Airport> getAll() {
        return repo.findAll();
    }
    public Airport create(Airport airport) {
        return repo.save(airport);
    }

    public Airport getAirport(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Airport update(Airport airport) {
        return repo.save(airport);
    }
}
