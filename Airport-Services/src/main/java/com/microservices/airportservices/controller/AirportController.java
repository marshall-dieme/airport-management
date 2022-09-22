package com.microservices.airportservices.controller;


import com.microservices.airportservices.entity.Airport;
import com.microservices.airportservices.entity.AirportDTO;
import com.microservices.airportservices.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airp")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }

    @GetMapping("/{airport_id}")
    public Optional<Airport> getById(@PathVariable Long airport_id) {
        return service.getById(airport_id);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public Airport update(@RequestBody AirportDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{airport_id}")
    public void delete(@PathVariable Long airport_id) {
        service.delete(airport_id);
    }

    @GetMapping("/{country}/{city}/airportgeo")
    public Airport findAirportByAirportGeo(@PathVariable String country,@PathVariable String city){
        return service.findAirportByAirportGeo(country, city);
    }

    @GetMapping("/airportName/{airportName}")
    public String getIdAirport(@PathVariable String airportName) {
        return service.getIdAirport(airportName);
    }

}
