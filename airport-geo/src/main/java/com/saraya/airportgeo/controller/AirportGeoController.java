package com.saraya.airportgeo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.airportgeo.model.Airport_Geo;
import com.saraya.airportgeo.model.Airport_GeoDto;
import com.saraya.airportgeo.service.AirportGeoService;

@RestController
@RequestMapping("/airportGeo")
public class AirportGeoController {
	
	    private final AirportGeoService service ;

	    public  AirportGeoController (AirportGeoService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<Airport_Geo> getAll(){
	        return service.getAll();
	    }

	    @GetMapping("/{country}")
	    public Airport_Geo getByCountry(@PathVariable String country){
	        return service.getByCountry(country);
	    }

	    @PostMapping
	    public Airport_Geo create(@RequestBody Airport_GeoDto airport_Geo){
	        return service.create(airport_Geo);
	    }

	    @PutMapping
	    public Airport_Geo update(@RequestBody Airport_GeoDto airport_Geo){
	        return service.update(airport_Geo);
	    }

	    @DeleteMapping("delete/{country}")
	    public void deleteByCountry(@PathVariable String country){
	        service.deleteByCountry(country);
	    }

	    

}
