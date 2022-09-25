package com.spring.airportservices.controller;

import com.spring.airportservices.DTO.AirportDto;
import com.spring.airportservices.bean.Airport;
import com.spring.airportservices.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {


    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    //<Retreive all users in Get>
    @GetMapping
    public List<Airport> getAll() {
        return service.getAll();
    }

    @GetMapping("/{city}/{country}/airportgeo")
    public List<Airport> getAirportByAirportGeo(@PathVariable String city, @PathVariable String country){
        return service.getAirportByAirportGeo(city, country);
    }

    @GetMapping("/{id}")
    public Optional<Airport> getById(@PathVariable int id) {
        return service.getById(id);
    }
    //<Add new user in Post>

    @PostMapping
    public Airport create(@RequestBody AirportDto airport) {
        return service.create(airport);
    }

    //<Add new user in Put>
    @PutMapping
    public Airport update( @RequestBody AirportDto airport) {
        return service.update(airport);
    }

    //<Delete new user by in Put>
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/airportName/{airportName}")
    public int getAirportId(@PathVariable String airportName){
        return service.getAirportId(airportName);
    }

}

