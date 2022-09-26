package com.saraya.airport.controller;

import com.saraya.airport.model.Airport;
import com.saraya.airport.service.ServiceAirport;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airport")
public class AirportController {
    private final ServiceAirport serviceAirport;

    public AirportController(ServiceAirport serviceAirport) {
        this.serviceAirport = serviceAirport;
    }

    @GetMapping
    public List<Airport> getAll() {
        return serviceAirport.findAirport();
    }

    @GetMapping("/{id}")
    public Optional<Airport> AirportRepositoryById(@PathVariable Long id) {
        return serviceAirport.getById(id);
    }

    @GetMapping("/iata/icao/name")
    public List<Airport> getListAirport(@PathVariable String iata, @PathVariable String icao, @PathVariable String name) {
        return serviceAirport.findAirport();
    }

    @PutMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return serviceAirport.createAirport(airport);
    }
    @PutMapping
    public Airport updateAirport(@RequestBody Airport airport){
        return serviceAirport.updateAirport(airport);

    }
    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id){
        serviceAirport.deleteAirport(id);
    }
}
