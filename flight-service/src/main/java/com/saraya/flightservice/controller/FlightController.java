package com.saraya.flightservice.controller;

import com.saraya.flightservice.model.Flight;
import com.saraya.flightservice.model.FlightDto;
import com.saraya.flightservice.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }


    @GetMapping
    public List<Flight> getAll(){
        return service.getAll();
    }


    @GetMapping("/{flightNo}")
    public Long getIdFlight(@PathVariable String flightNo){
        return service.getFlightId(flightNo);
    }


    @PostMapping("/")
    public Flight create(@RequestBody FlightDto dto) {

        return service.create(dto);
    }

    @PutMapping("/")
    public Flight update (@RequestBody Flight airportGeo){
        return service.update(airportGeo);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
