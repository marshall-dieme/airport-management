package com.saraya.airport_geoservices.controller;

import com.saraya.airport_geoservices.model.Airport_geo;
import com.saraya.airport_geoservices.service.Airport_geoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("airport-geo")

public class Airport_geoController {

    private final Airport_geoService service;

    public Airport_geoController(Airport_geoService service) {

        this.service = service;
    }

    @GetMapping
    public List<Airport_geo> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Airport_geo> getAirportGeoById(@PathVariable Long id){
        return service.getById(id);
    }
    @GetMapping("/country/city/{country}/{city}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


}
