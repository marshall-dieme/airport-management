package com.saraya.airportservice.controller;

import com.saraya.airportservice.bean.Airport;
import com.saraya.airportservice.bean.AirportDto;
import com.saraya.airportservice.bean.AirportGeo;
import com.saraya.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Airport")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }
//
    @GetMapping("/{name}")
    public Optional<Airport> getById(@PathVariable("name") String name){
        return service.getByName(name);
    }
//
    @GetMapping("/airportGeo/{country}/{city}")
    public AirportGeo getContryAndCity(@PathVariable("country") String country,
                                       @PathVariable("city") String city){
         return service.getAirportGeo(country, city);
    }
//
    @PostMapping
    public Airport create(@RequestBody AirportDto dto){
        return service.create(dto);
    }
//
    @PutMapping
    public AirportDto update(@RequestBody AirportDto dto){
        return service.update(dto);
    }
//
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        service.delete(id);
    }
}
