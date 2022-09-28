package com.saraya.Airport_Geoservice.controller;

import com.saraya.Airport_Geoservice.model.Airport_Geo;
import com.saraya.Airport_Geoservice.service.Airport_GeoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Airport_Geo")
public class Airport_GeoController {
    private final Airport_GeoService service;

    @GetMapping
    public List<Airport_Geo> getAllAirport_GeoControl() {
        return service.getAllAirport_GeoServices();
    }
    /*@GetMapping
    public List<Airport_Geo> getAllAirport_GeoControl(@) {
        return service.getAllAirport_GeoServices();
    }*/

    @GetMapping("/{id}")
    public Airport_Geo getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Airport_Geo create(@RequestBody Airport_Geo airport_Geo) {
        return service.create(airport_Geo);
    }

    @PutMapping
    public Airport_Geo update(@RequestBody Airport_Geo airport_Geo) {
        return service.update(airport_Geo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{country}/{city}")
    public Airport_Geo getByCountryAndCity(@PathVariable String country, @PathVariable String city) {
        return service.getByCountryAndCity(country, city);
    }

}
