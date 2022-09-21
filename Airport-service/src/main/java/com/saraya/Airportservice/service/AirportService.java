package com.saraya.Airportservice.service;

import com.saraya.Airportservice.model.Airport;
import com.saraya.Airportservice.repository.AirportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AirportService {

    private final AirportRepository repository;

    public List<Airport> getAllAirports() {
        return repository.findAll();
    }

    public Airport getAirport(Long airport_id) {
        return repository.getReferenceById(airport_id);
    }

    public Airport saveAirport(Airport airport) {
        return repository.save(airport);
    }

    public Airport updateAirport(Airport airport) {
        return repository.save(airport);
    }

    public void deleteAirport(Long airport_id) {
        repository.deleteById(airport_id);
    }
}
