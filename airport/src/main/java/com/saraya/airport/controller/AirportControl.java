package com.saraya.airport.controller;

import com.saraya.airport.model.Airport;
import com.saraya.airport.Dto.AirportDto;
import com.saraya.airport.service.Airportservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Airports")
public class AirportControl {
    private final Airportservice service;

    public AirportControl(Airportservice service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAllAirportControl() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Airport getById(@PathVariable Long id) {
        return service.getAirport(id);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDto airport) {
        return service.create(airport);
    }

    @PutMapping
    public Airport update(@RequestBody Airport airport) {
        return service.update(airport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
