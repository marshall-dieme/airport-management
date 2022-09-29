package com.saraya.airport.controller;

import com.saraya.airport.model.Airport;
import com.saraya.airport.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAll() {
        return service.getAll();
    }

    @GetMapping("/iata/icao/name/{iata}/{icao}/{name}")
    public Long getIdAirport(@PathVariable String iata, @PathVariable String icao, @PathVariable String name) {
        return service.getIdAirport(iata, icao, name);
    }

    @PostMapping
    public Airport create(@RequestBody Airport airport) {
        return service.create(airport);
    }

    @PutMapping
    public Airport update(@RequestBody Airport airport) {
        return service.update(airport);
    }
    @DeleteMapping("delete/{iata}/{icao}/{name}")
    public  void deleteByName(@PathVariable String iata, @PathVariable String icao, @PathVariable String name){
        service.deleteByiataandicaoandname(iata, icao, name);
    }
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }

}
