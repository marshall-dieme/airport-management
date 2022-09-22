package com.saraya.airport_geoservice.controller;


import com.saraya.airport_geoservice.model.AirportGeo;
import com.saraya.airport_geoservice.service.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Airport_Geo-service")
public class AirportGeoController {
    private final AirportGeoService service;

    public AirportGeoController(AirportGeoService service) {
        this.service = service;
    }

    @GetMapping
    public List<AirportGeo> getAllAirport(){
        return service.getAllAirport();
    }
    @GetMapping("/airport_geo_id")
    public AirportGeo getById(@PathVariable Long airport_geo_id){
        return service.getById(airport_geo_id).get();
    }

    @GetMapping("/{country}/{city}")
    public AirportGeo getByCountryAndCity(@PathVariable String country, @PathVariable String city){
      return service.getByCountryAndCity(country, city);
    }
    @PostMapping
    public AirportGeo createAirport(@RequestBody AirportGeo airportGeo){
        return service.saveAirport(airportGeo);
    }

    @PutMapping
    public  AirportGeo update(@RequestBody AirportGeo airportGeo){
        return service.update(airportGeo);
    }

    @DeleteMapping("/{airport_geo_id}")
    public void delete(@PathVariable Long airport_geo_id){
        service.delete(airport_geo_id);

    }
}
