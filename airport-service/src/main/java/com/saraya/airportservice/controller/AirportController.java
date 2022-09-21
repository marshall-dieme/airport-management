package com.saraya.airportservice.controller;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDTO;
import com.saraya.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {

    public final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }


    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }

    @GetMapping("/{iata}")
    public Airport getByIata(
            @PathVariable String iata){
        return service.getByIata(iata);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDTO airport){
        return service.create(airport);
    }

    @PutMapping
    public Airport update(@RequestBody AirportDTO airport){
        return service.update(airport);
    }

    @DeleteMapping("delete/{iata}")
    public void deleteByIata(
            @PathVariable String iata){
        service.deleteByIata(iata);
    }

    @DeleteMapping("/{airport_id}")
    public void deleteById(@PathVariable int airport_id){
        service.deleteById(airport_id);
    }

}
