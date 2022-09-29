package com.regulus.airportservice.controllers;

import com.regulus.airportservice.Dtos.AirportDto;
import com.regulus.airportservice.models.Airport;
import com.regulus.airportservice.services.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<Airport> getAirportList(){
        return airportService.getAirport();
    }

    @GetMapping("/name/{name}")
    public Integer getAirportIDByName(@PathVariable("name") String name){
        return airportService.getAirportID(name);
    }

    @PostMapping
    public AirportDto create(@RequestBody AirportDto airportDto){
        return airportService.createAirport(airportDto);
    }

    @PutMapping("/{id}")
    public AirportDto update(@PathVariable("id") int id, @RequestBody AirportDto airportDto){
        return airportService.updateAirport(airportDto, id);
    }

    @GetMapping("/{id}")
    public AirportDto getAirport(@PathVariable("id") int id ){
        return airportService.getAirport(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable("id") int id){
        airportService.deleteAirport(id);
    }

}
