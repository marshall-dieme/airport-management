package com.saraya.airportgeo.controller;

import com.saraya.airportgeo.model.AirportGeo;
import com.saraya.airportgeo.service.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geo")
public class AirportGeoController {

    private final AirportGeoService service;

    public AirportGeoController(AirportGeoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AirportGeo> getAll() {
        return service.getAll();
    }

    @GetMapping("/city/country/{city}/{country}")
    public Long getIdAirportGeo(@PathVariable String city, @PathVariable String country) {
        return service.getIdAirportGeo(city, country);
    }

    @PostMapping("/")
    public AirportGeo create(@RequestBody AirportGeo airportGeo) {
        return service.create(airportGeo);
    }

    @PutMapping("/")
    public AirportGeo update(@RequestBody AirportGeo airportGeo) {
        return service.update(airportGeo);
    }

    @DeleteMapping("delete/{city}/{country}")
    public void delateByName(@PathVariable String city, @PathVariable String country) {
        service.deleteByCityAndCountry(city, country);
    }

    public void deleteById(@PathVariable Long id) {
        service.delete(id);
    }


}
