package com.saraya.airlineservice.controller;

import com.saraya.airlineservice.model.Airline;
import com.saraya.airlineservice.model.AirlineDTO;
import com.saraya.airlineservice.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{airlineName}")
    public Airline getByAirlineName(
            @PathVariable String airlineName){
        return service.getByAirlineName(airlineName);
    }

    @PostMapping
    public Airline create(@RequestBody AirlineDTO airline){
        return service.create(airline);
    }

    @PutMapping
    public Airline update(@RequestBody AirlineDTO airline){
        return service.update(airline);
    }

    @DeleteMapping("delete/{airlineName}")
    public void deleteByAirlineName(
            @PathVariable String airlineName){
        service.deleteByAirlineName(airlineName);
    }

    @DeleteMapping("/{airlineId}")
    public void deleteById(@PathVariable int airlineId){
        service.deleteById(airlineId);
    }

}
