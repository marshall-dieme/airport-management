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

    @PostMapping("/airplane/{flightId}/{airplaneCapacity}")
    public Flight putAirplaneForAirline(@PathVariable("flightId") int flightId, @PathVariable("airplaneCapacity") int airplaneCapacity){
        return service.putAirplaneForFlight(flightId, airplaneCapacity);
    }

    @PostMapping("/booking/{flightId}/{priceBooking}")
    public Flight putbookingForFlight(@PathVariable("flightId") int flightId, @PathVariable("priceBooking") int priceBooking){
        return service.putbookingForFlight(flightId, priceBooking);
    }

    @PostMapping("/timetable/{flightId}/{airline}")
    public String putTimeTableForFlight(@PathVariable("flightId") int flightId, @PathVariable("airline") String airline){
        return service.putTimeTableForFlight(flightId, airline);
    }

    @GetMapping("/{flightNo}")
    public int idAirline(@PathVariable("flightNo") String flightNo){
        return service.getId(flightNo);
    }

    @GetMapping
    public List<Flight> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Flight create(@RequestBody FlightDto dto){
        return service.create(dto);
    }

    @PutMapping
    public Flight update(@RequestBody FlightDto dto){
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody FlightDto dto){
        service.delete(dto);
    }
}
