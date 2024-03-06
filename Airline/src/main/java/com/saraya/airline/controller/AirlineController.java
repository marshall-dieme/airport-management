package com.saraya.airline.controller;

import com.saraya.airline.model.Airline;
import com.saraya.airline.model.AirlineDto;
import com.saraya.airline.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airline")
public class AirlineController {

    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }


    @GetMapping("airlineName/{airlineName}")
    public Long getIdAirportGeo(@PathVariable String airlineName){
        return service.getIdAirline(airlineName);
    }

    @GetMapping("{airportName}/airport")
    public List <Airline>  getAirlinesByAirport(@PathVariable String airportName) {
        return service.getAirlinesByAirport(airportName);
    }


    @PostMapping
    public Airline create(@RequestBody AirlineDto dto) {

        return service.create(dto);
    }

    @PutMapping
    public Airline update (@RequestBody AirlineDto dto){
        return service.update(dto);
    }



    @DeleteMapping("{airline_id}")
    public void deleteById(@PathVariable Long airline_id){
        service.deleteById(airline_id);
    }

}
