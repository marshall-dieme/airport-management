package com.saraya.flightservice.controller;

import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
public class FlightController {
    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }
    @GetMapping
    public List<Flight> getAllAirplaneType(){
        return service.save();
    }
    @GetMapping("/{id}")
    public Optional<Flight> findFlightById(@PathVariable("id") Long flight_id){
        return service.findById(flight_id);
    }
    @PostMapping("/")
    public Flight saveFlight(@RequestBody Flight flight){
        return service.saveFlight(flight);
    }
    @PutMapping("/")
    public Flight updateFlight(@RequestBody Flight flight){
        return service.update(flight);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long flight_id){
        service.delete(flight_id);
    }
}
