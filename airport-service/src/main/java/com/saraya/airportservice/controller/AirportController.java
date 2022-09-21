package com.saraya.airportservice.controller;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Airport")
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
    public Optional<Airport> getById(@PathVariable("id") String id){
        return service.getById(id);
    }

    @PostMapping
    public Airport create(@RequestBody Airport airport){
        return service.create(airport);
    }

    @PutMapping
    public Airport update(@RequestBody Airport airportGeo){
        return service.update(airportGeo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
