package com.saraya.microservice.airportGeoservice.controller;


import com.saraya.microservice.airportGeoservice.model.AirportGeo;
import com.saraya.microservice.airportGeoservice.service.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/arpgs")
public class AirportGeoController {
    private final AirportGeoService service ;

    public AirportGeoController(AirportGeoService service) {
        this.service = service;
    }


    @GetMapping
    public List<AirportGeo> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AirportGeo getById(@PathVariable Integer airport_geo_id) {
        return service.getById(airport_geo_id);
    }

    @PostMapping
    public AirportGeo create(@RequestBody AirportGeo arpg) {
        return service.create(arpg);
    }

    @PutMapping
    public AirportGeo update(@RequestBody AirportGeo arpg) {
        return service.update(arpg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer airport_geo_id) {
        service.delete(airport_geo_id);
    }

    @GetMapping("/country/city/{country}/{city}")
    public Integer getIdAirportGeo(@PathVariable String country,@PathVariable String city)
    {
        return service.getIdAirportGeo(country,city);
    }

    /*@GetMapping("/country/{country}")
    public AirportGeo getIdDept(@PathVariable String country)
    {
        return service.getIdArp(country);
    }
*/
}
