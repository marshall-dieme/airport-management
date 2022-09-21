package com.saraya.airportgeoservice.controller;

import com.saraya.airportgeoservice.model.AirportGeo;
import com.saraya.airportgeoservice.services.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;

@RestController
@RequestMapping("/geo")
public class AirportGeoController {


    private final AirportGeoService service;

    public AirportGeoController(AirportGeoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AirportGeo> getAll(){
        return service.getAll();
    }

    /*@GetMapping("/{city}/{country}")
    public AirportGeo getByCityAndCountry(String city, String country){
        return service.getByCityAndCountry(city,country);
    }*/

    @GetMapping("/city/country/{city}/{country}")
    public Long getIdAirportGeo(@PathVariable String city, @PathVariable String country){
        return service.getIdAirportGeo(city, country);
    }


    @PostMapping("/")
    public AirportGeo create(@RequestBody AirportGeo airportGeo) {

        return service.create(airportGeo);
    }

    @PutMapping("/")
    public AirportGeo update (@RequestBody AirportGeo airportGeo){
        return service.update(airportGeo);
    }

    @DeleteMapping("delete/{city}/{country}")
    public void deleteByName(@PathVariable String city, String country){
        service.deleteByCityAndCountry(city,country);

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
