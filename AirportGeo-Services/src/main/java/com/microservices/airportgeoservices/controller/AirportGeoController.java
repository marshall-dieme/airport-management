package com.microservices.airportgeoservices.controller;


import com.microservices.airportgeoservices.entity.AirportGeo;
import com.microservices.airportgeoservices.service.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
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
    public Optional<AirportGeo> getById(@PathVariable Long airport_geo_id) {
        return service.getById(airport_geo_id);
    }

    @PostMapping
    public AirportGeo create(@RequestBody AirportGeo airportGeo) {
        return service.create(airportGeo);
    }

    @PutMapping
    public AirportGeo update(@RequestBody AirportGeo airportGeo) {
        return service.update(airportGeo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long airport_geo_id) {
        service.delete(airport_geo_id);
    }



}
