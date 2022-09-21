package com.saraya.airportservice.controller;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Airport create(@RequestBody Airport airport) {
        return service.create(airport);
    }

    @PutMapping("/{id}")
    public Airport update(@PathVariable("id") int id, @RequestBody Airport airport) {
        return service.update(id, airport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}

