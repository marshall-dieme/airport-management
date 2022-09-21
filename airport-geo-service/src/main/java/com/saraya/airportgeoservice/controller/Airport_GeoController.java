package com.saraya.airportgeoservice.controller;

import com.saraya.airportgeoservice.model.Airport_Geo;
import com.saraya.airportgeoservice.service.Airport_GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airport_geo")
public class Airport_GeoController {


    private final Airport_GeoService service;

    public Airport_GeoController(Airport_GeoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport_Geo> getAll(){

        return service.getAll();
    }
    @GetMapping("/{geo_id}")
    public Airport_Geo getById(@PathVariable Long geo_id){
        return service.getById(geo_id);
    }

    @PostMapping
    public Airport_Geo create(@RequestBody Airport_Geo airport_geo ){
        return service.create(airport_geo);
    }
    @PutMapping
    public Airport_Geo edit(@RequestBody Airport_Geo airport_geo){

        return service.update(airport_geo);
    }
    @DeleteMapping("/{geo_id}")
    public void delete(@PathVariable Long geo_id){
        service.delete(geo_id);
    }


    public Airport_Geo getAirport_Geo(String country, String city){
        return service.getIdAirport_Geo(country,city);
    }
}
