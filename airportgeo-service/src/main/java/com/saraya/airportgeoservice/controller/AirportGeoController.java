package com.saraya.airportgeoservice.controller;

import com.saraya.airportgeoservice.bean.Airport;
import com.saraya.airportgeoservice.bean.AirportGeo;
import com.saraya.airportgeoservice.bean.AirportGeoDto;
import com.saraya.airportgeoservice.service.AirportGeoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Optional<AirportGeo> getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @GetMapping("/{country}/{city}")
    public Optional<AirportGeo> getById(@PathVariable("country") String country,
                                        @PathVariable("city") String city){
       return service.getByCountryAndCity(country, city);
    }

    @GetMapping("/{name}")
    public Airport getById(@PathVariable("name") String name) {
        return service.getAirportByName(name);
    }

    @PostMapping
    public AirportGeo create(@RequestBody AirportGeoDto dto){
        return service.create(dto);
    }

    @PutMapping
    public AirportGeo update(@RequestBody AirportGeo airportGeo){
        return service.update(airportGeo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
