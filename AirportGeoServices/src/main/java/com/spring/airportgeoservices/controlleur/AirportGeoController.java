package com.spring.airportgeoservices.controlleur;


import com.spring.airportgeoservices.bean.AirportGeo;
import com.spring.airportgeoservices.service.AirportGeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airportgeo")
public class AirportGeoController {

    @Autowired
    private AirportGeoService service;

    @GetMapping
    public List<AirportGeo> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AirportGeo> getById(@PathVariable String id){
        return service.getById(id);
    }

    @PostMapping
    public AirportGeo create(@RequestBody AirportGeo airportGeo){
        return service.create(airportGeo);
    }

    @PutMapping
    public AirportGeo update(@RequestBody AirportGeo airportGeo){
        return service.update(airportGeo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/city/country/{city}/{country}")
    public String getAirportGeoId(@PathVariable String city, @PathVariable String country){
        return service.getAirportGeoId(city, country);
    }




}
