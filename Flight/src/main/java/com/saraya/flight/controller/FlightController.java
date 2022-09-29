package com.saraya.flight.controller;


import com.saraya.flight.dto.FlightDto;
import com.saraya.flight.model.Flight;
import com.saraya.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService service;


    @PostMapping
    public FlightDto create(@RequestBody FlightDto flightDto){
        return service.saveFlight(flightDto);
    }

    @GetMapping
    public List<Flight> getAll(){
        return service.findAllFlight();
    }

    @GetMapping("/{flight_id}")
    public FlightDto getById(@PathVariable long flight_id){
        return service.getFlightById(flight_id);

    }

    @DeleteMapping("/{flight_id}")
    public void delete(@PathVariable long flight_id){
        service.deleteById(flight_id);
    }
}
