package com.saraya.Airport.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Airport.model.Airport;
import com.saraya.Airport.model.AirportDto;
import com.saraya.Airport.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {
	
	 private final AirportService service ;

	    public  AirportController (AirportService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<Airport> getAll(){
	        return service.getAll();
	    }

	    @GetMapping("/{iata}")
	    public Airport getByiata(@PathVariable String iata){
	        return service.getByIata(iata);
	    }

	    @PostMapping
	    public Airport create(@RequestBody AirportDto airportDto){
	        return service.create(airportDto);
	    }
	   

	    @PutMapping
	    public Airport update(@RequestBody AirportDto airportDto){
	        return service.update(airportDto);
	    }

	    @DeleteMapping("delete/{iata}")
	    public void deleteByIata(@PathVariable String iata){
	        service.getByIata(iata);
	    }


}
