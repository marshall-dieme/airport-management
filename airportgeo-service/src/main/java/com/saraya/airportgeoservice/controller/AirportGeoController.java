package com.saraya.airportgeoservice.controller;

import com.saraya.airportgeoservice.bean.AirportGeo;
import com.saraya.airportgeoservice.service.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/AirportGeo")
public class AirportGeoController {

    private final AirportGeoService service;

    public AirportGeoController(AirportGeoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AirportGeo> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<AirportGeo> getById(@PathVariable("id") String id){
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
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
