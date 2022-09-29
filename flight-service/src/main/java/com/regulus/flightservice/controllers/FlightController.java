package com.regulus.flightservice.controllers;


import com.regulus.flightservice.dtos.FlightDto;
import com.regulus.flightservice.models.Flight;
import com.regulus.flightservice.services.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public List<Flight> getFlightList(){
        return flightService.getFlight();
    }

    @PostMapping
    public FlightDto create(@RequestBody FlightDto flightDto){
        return flightService.createFlight(flightDto);
    }

    @PutMapping("/{id}")
    public FlightDto update(@PathVariable("id") int id, @RequestBody FlightDto flightDto){
        return flightService.updateFlight(flightDto, id);
    }

    @GetMapping("/{id}")
    public FlightDto getFlight(@PathVariable("id") int id ){
        return flightService.getFlight(id);
    }

    @GetMapping("/flightNo/{flightNo}")
    public Integer getFlightId(@PathVariable("flightNo") String flightNo){
        return flightService.getFlightId(flightNo);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable("id") int id){
        flightService.deleteFlight(id);
    }

}
