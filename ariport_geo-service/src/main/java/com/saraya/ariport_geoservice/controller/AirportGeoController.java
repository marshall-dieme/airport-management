package com.saraya.ariport_geoservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.ariport_geoservice.model.AirportGeo;
import com.saraya.ariport_geoservice.service.AirportGeoService;

@RestController
@RequestMapping("/geo")
public class AirportGeoController {	
	
	private final AirportGeoService service;
	
	public AirportGeoController(AirportGeoService service) {
		this.service= service;
	}

	@GetMapping
	public List<AirportGeo> getAll(){
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public AirportGeo getById(@PathVariable Long id){
		return service.getById(id);
	}
	 @GetMapping("/country/city/{country}/{city}")
	    public Long getIdAirportGeo(@PathVariable String city, @PathVariable String country){
	        return service.getAirportGeoId(country, city);
	    }
	
	@PostMapping
	public AirportGeo create(@RequestBody AirportGeo airportGeo) {
		return service.create(airportGeo);
	}
    @PutMapping("/update/{id}")
    public AirportGeo update(@RequestBody AirportGeo airportGeo, @PathVariable Long id) {
    	return service.update(airportGeo, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	service.delete(id);
    }
}
