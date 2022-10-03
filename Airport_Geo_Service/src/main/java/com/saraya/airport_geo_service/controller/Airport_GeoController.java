package com.saraya.airport_geo_service.controller;

import com.saraya.airport_geo_service.model.Airport_Geo;
import com.saraya.airport_geo_service.service.Airport_GeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airport_geo")
public class Airport_GeoController {
    private final Airport_GeoService service;

    public Airport_GeoController(Airport_GeoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Airport_Geo> getAll(){
        return service.getAll();
    }

    @GetMapping("/country/city/{country}/{city}")
    public Long getIdByCountryAndCity(
            @PathVariable String country , @PathVariable String city){
        return service.getIdByCountryAndCity(country, city);
    }

    @PostMapping("/")
    public Airport_Geo create(@RequestBody Airport_Geo airportGeo){
        return service.create(airportGeo);
    }

    @PutMapping("/")
    public Airport_Geo update(@RequestBody Airport_Geo airportGeo){
        return service.update(airportGeo);
    }

//    @DeleteMapping("delete/{country}/{city}")
//    public void deleteByCountryAndCity(
//            @PathVariable String country , @PathVariable String city){
//        service.deleteByCountryAndCity(country, city);
//    }

    @DeleteMapping("/{airport_geo_id}")
    public void deleteById(@PathVariable Long airport_geo_id){
        service.deleteById(airport_geo_id);
    }

//    @GetMapping("/{country}/{city}")
//    public Long findByCountryAndCity(@PathVariable String country, @PathVariable String city){
//        return service.findByCountryAndCity(country,city).getAirport_geo_id();
//    }
}
