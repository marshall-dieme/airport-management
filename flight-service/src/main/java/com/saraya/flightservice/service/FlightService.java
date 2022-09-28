package com.saraya.flightservice.service;

import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.repo.FlightRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepo repo;

    public FlightService(FlightRepo repo) {
        this.repo = repo;
    }

    public List<Flight> save() {
        return repo.findAll();
    }

    public Optional<Flight> findById(Long flight_id) {
        return repo.findById(flight_id);
    }

    public Flight saveFlight(Flight flight) {
        return repo.save(flight);
    }

    public Flight update(Flight flight) {
        return repo.save(flight);
    }

    public void delete(Long flight_id) {
        repo.deleteById(flight_id);
    }
}
