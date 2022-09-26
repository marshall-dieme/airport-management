package com.saraya.airport.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.airport.model.Airport;
import com.saraya.airport.model.AirportDTO;
import com.saraya.airport.service.AirportService;


@RestController
@RequestMapping("/airport")
public class AirportController {
	
private final AirportService service;
	
	public AirportController(AirportService service) {
		this.service= service;
	}

	@GetMapping
	public List<Airport> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Airport getById(@PathVariable Long id){
		return service.getById(id);
	}
	@GetMapping("/name/{airportName}")
	public Long getByName(@PathVariable String airportName) {
		return service.getByName(airportName);
	}
	@GetMapping("{country}/{city}")
	public Airport getByAirportGeo(@PathVariable String country, @PathVariable String city) {
		return service.getAirportByAirportGeo(country, city);
	}
	@PostMapping
	public Airport create(@RequestBody AirportDTO dto) {
		return service.create(dto);
	}
    @PutMapping("/update/{id}")
    public AirportDTO update(@RequestBody AirportDTO dto, @PathVariable Long id) {
    	return service.update(dto,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	service.delete(id);
    }

}
