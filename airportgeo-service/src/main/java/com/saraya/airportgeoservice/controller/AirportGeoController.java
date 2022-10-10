package com.saraya.airportgeoservice.controller;

import com.saraya.airportgeoservice.bean.AirportGeo;
import com.saraya.airportgeoservice.dto.AirportGeoDto;
import com.saraya.airportgeoservice.service.AirportGeoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AirportGeo")
public class AirportGeoController {

    private final AirportGeoService service;

    public AirportGeoController(AirportGeoService service) {
        this.service = service;
    }

    @GetMapping("/airport/{airportGeoid}/{airportName}")
    public String putAirportIdForAirportGeo(@PathVariable("airportGeoid") int airportId,
                                            @PathVariable("airportName") String airportName){
        return service.putAirportIdforAirportGeoId(airportId, airportName);
    }

    @GetMapping("/{country}/{city}")
    public int getById(@PathVariable("country") String country,
                       @PathVariable("city") String city){
        return service.getIdByCountryAndCity(country, city);
    }

    @GetMapping("/{id}")
    public AirportGeo getById(@PathVariable("id") int id){
        return service.getById(id);
    }

    @GetMapping
    public List<AirportGeo> getAll(){
        return service.getAll();
    }

    @PostMapping
    public AirportGeo create(@RequestBody AirportGeoDto dto){
        return service.create(dto);
    }

    @PutMapping
    public AirportGeo update(@RequestBody AirportGeoDto airportGeo){
        return service.update(airportGeo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }

}
