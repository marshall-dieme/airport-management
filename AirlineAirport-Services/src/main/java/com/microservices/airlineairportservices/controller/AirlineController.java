package com.microservices.airlineairportservices.controller;

import com.microservices.airlineairportservices.entity.Airline;
import com.microservices.airlineairportservices.entity.AirlineDTO;
import com.microservices.airlineairportservices.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/airline")
public class AirlineController {

    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }
    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

    @GetMapping("/{airline_id}")
    public Optional<Airline> getById(@PathVariable Long airline_id) {
        return service.getById(airline_id);
    }

    @PostMapping("/create")
    public Airline create(@RequestBody AirlineDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public Airline update(@RequestBody AirlineDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{airline_id}")
    public void delete(@PathVariable Long airline_id) {
        service.delete(airline_id);
    }

    @GetMapping("/{airportName}/aiportname")
    public List<Airline> findAirportByAirline(@PathVariable String airportName){
        return service.findAirportByAirline(airportName);
    }

    @GetMapping("/airlineName/{airlineName}")
    public String getIdAirline(@PathVariable String airlineName) {
        return service.getIdAirline(airlineName);
    }

}
