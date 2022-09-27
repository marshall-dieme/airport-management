package com.saraya.flightservice.controller;

import com.saraya.flightservice.bean.Flight;
import com.saraya.flightservice.dto.FlightDto;
import com.saraya.flightservice.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Flight")
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
    public int idAirline(@PathVariable("flightNo") String flightNo){
        return service.getId(flightNo);
    }

    @PostMapping
    public Flight create(@RequestBody FlightDto dto){
        return service.create(dto);
    }

    @PostMapping("/airplane/{flightId}/{airplaneCapacity}")
    public Flight putAirplaneForAirline(@PathVariable("flightId") int flightId, @PathVariable("airplaneCapacity") int airplaneCapacity){
        return service.putAirplaneForFlight(flightId, airplaneCapacity);
    }

    @PostMapping("/booking/{flightId}/{priceBooking}")
    public Flight putbookingForFlight(@PathVariable("flightId") int flightId, @PathVariable("priceBooking") int priceBooking){
        return service.putbookingForFlight(flightId, priceBooking);
    }
}
