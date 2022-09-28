package com.saraya.flightservice.controller;

import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @GetMapping
    public List<Flight> getAll(){
        return service.getAll();
    }

    @GetMapping("/recup/{flightNo}")
    public Flight getByflightNo(
            @PathVariable String flightNo){
        return service.getByFlightNo(flightNo);
    }

    @PostMapping
    public Flight create(@RequestBody Flight flight){
        return service.create(flight);
    }

    @PutMapping
    public Flight update(@RequestBody Flight flight){
        return service.update(flight);
    }

    @DeleteMapping("delete/{flightNo}")
    public void deleteByFlightNo(
            @PathVariable String flightNo ){
        service.deleteByFlightNo(flightNo);
    }

    @DeleteMapping("/{flightId}")
    public void deleteById(@PathVariable int flightId){
        service.deleteById(flightId);
    }
}
