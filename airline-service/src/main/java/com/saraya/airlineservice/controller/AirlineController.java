package com.saraya.airlineservice.controller;

import com.saraya.airlineservice.bean.Airline;
import com.saraya.airlineservice.dto.AirlineDto;
import com.saraya.airlineservice.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Airline")
public class AirlineController {

    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Airline create(@RequestBody AirlineDto dto){
        return service.create(dto);
    }

    @GetMapping("/{nameAirline}")
    public int idAirline(@PathVariable("nameAirline") String nameAirline){
        return service.getIdAirlineByName(nameAirline);
    }

    @PostMapping("/{airlineId}/{airportName}")
    public Airline putAirportForAirline(@PathVariable("airlineId") int airlineId, @PathVariable("airportName") String airportName){
        return service.putAirportForAirline(airlineId, airportName);
    }

    @PostMapping("/airplane/{airlineId}/{airplaneCapacity}")
    public Airline putAirplaneForAirline(@PathVariable("airlineId") int airlineId, @PathVariable("airplaneCapacity") int airplaneCapacity){
        return service.putAirplaneForAirline(airlineId, airplaneCapacity);
    }
}
