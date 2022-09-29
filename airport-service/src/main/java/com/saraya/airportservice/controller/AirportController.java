package com.saraya.airportservice.controller;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDto;
import com.saraya.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airport")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {

        this.service = service;
    }

   @GetMapping
    public List<Airport> getAll(){
        return service.getAirport();
    }

    @GetMapping("/{airport_id}")
    public Airport getIdAirport(@PathVariable Long airport_id){


        return service.getById(airport_id);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDto dto){

        return service.CreateAirport(dto);
    }
    @PutMapping
    public Airport edit(@RequestBody AirportDto dto){

        return service.updateAirport(dto);

    }

    @DeleteMapping("/{airport_id}")
    public void delete(@PathVariable Long airport_id){

        service.deleteAirport(airport_id);
    }
    @GetMapping("/airport_name/{airport_name}")
    public Long getAirportId(@PathVariable String airport_name){
        return service.getId(airport_name);
    }

}
