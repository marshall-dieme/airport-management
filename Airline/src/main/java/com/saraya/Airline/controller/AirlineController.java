package com.saraya.Airline.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.saraya.Airline.model.Airline;
import com.saraya.Airline.model.AirlineDto;
import com.saraya.Airline.service.AirlineService;

@RestController
@RequestMapping("/airline")
public class AirlineController {
	
	private final AirlineService service ;

    public  AirlineController (AirlineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

    @GetMapping("/{airline_name}")
    public Airline getByAirline_name(@PathVariable String airline_name){
        return service.getByAirline_name(airline_name);
    }

    @PostMapping
    public Airline create(@RequestBody AirlineDto airlineDto){
        return service.create(airlineDto);
    }

    @PutMapping
    public Airline update(@RequestBody AirlineDto airlineDto){
        return service.update(airlineDto);
    }

    @DeleteMapping("delete/{airline_name}")
    public void deleteByAirline_name(@PathVariable String airline_name){
        service.getByAirline_name(airline_name);
    }

	
	
}
