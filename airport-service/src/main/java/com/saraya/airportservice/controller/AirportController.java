package com.saraya.airportservice.controller;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport-service")
public class AirportController {
    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }


    @GetMapping("/{iata}/{icao}/{airport_name}")
    public Airport getByCountryAndCity(@PathVariable String iata, @PathVariable String icao, @PathVariable String airport_name){
        return service.getByCountryAndCity(iata, icao, airport_name);
    }
    @PostMapping
    public Airport createAirport(@RequestBody Airport airport){
        return service.saveAirport(airport);
    }

    @DeleteMapping("/{airport_id}")
    public Long delete(@PathVariable Long airport_id){
        return service.delete(airport_id);

    }
}
