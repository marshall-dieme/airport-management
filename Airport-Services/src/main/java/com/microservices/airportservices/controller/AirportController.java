package com.microservices.airportservices.controller;


import com.microservices.airportservices.entity.Airport;
import com.microservices.airportservices.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("airp")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Airport> getById(@PathVariable Long airport_id) {
        return service.getById(airport_id);
    }

    @PostMapping
    public Airport create(@RequestBody Airport airport) {
        return service.create(airport);
    }

    @PutMapping
    public Airport update(@RequestBody Airport airport) {
        return service.update(airport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long airport_id) {
        service.delete(airport_id);
    }

}
