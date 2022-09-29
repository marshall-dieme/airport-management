package com.regulus.airportgeoservice.controllers;

import com.regulus.airportgeoservice.DTO.AirportGeoDto;
import com.regulus.airportgeoservice.models.AirportGeo;
import com.regulus.airportgeoservice.services.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airportgeo")
public class AirportGeoController {

    private final AirportGeoService airportGeoService;

    public AirportGeoController(AirportGeoService airportGeoService) {
        this.airportGeoService = airportGeoService;
    }

    @GetMapping
    public List<AirportGeo> getAirportGeoList(){
        return airportGeoService.getAirportGeo();
    }

    @PostMapping
    public AirportGeoDto create(@RequestBody AirportGeoDto airportGeoDto){
        return airportGeoService.createAirportGeo(airportGeoDto);
    }

    @PutMapping("/{id}")
    public AirportGeoDto update(@PathVariable("id") int id, @RequestBody AirportGeoDto airportGeoDto){
        return airportGeoService.updateAirportGeo(airportGeoDto, id);
    }

    @GetMapping("/{id}")
    public AirportGeoDto getAirportGeo(@PathVariable("id") int id ){
        return airportGeoService.getAirportGeo(id);
    }

    @GetMapping("/city/country/{city}/{country}")
    public Integer getAirportGeoByCityAndCountry(@PathVariable("city") String city,@PathVariable("country") String country){
        return airportGeoService.getAirportGeo(city, country);
    }

    @DeleteMapping("/{id}")
    public void deleteAirportGeo(@PathVariable("id") int id){
        airportGeoService.deleteAirportGeo(id);
    }

}
