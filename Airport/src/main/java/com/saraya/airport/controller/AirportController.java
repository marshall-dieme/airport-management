package com.saraya.airport.controller;

import com.saraya.airport.model.Airport;
import com.saraya.airport.model.AirportDto;
import com.saraya.airport.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airport")
public class AirportController {

    private final AirportService service;


    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airport> getAll() {
        return service.getAll();
    }

    @GetMapping("airportName/{airport_name}")
    public Long getByName(@PathVariable String airport_name) {
        return service.getIdAirport(airport_name);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Airport update(@RequestBody  AirportDto dto) {
        return service.update(dto);
    }
    @DeleteMapping("delete/{airport_id}")
    public void deleteById(@PathVariable Long airport_id) {
        service.deleteByName(airport_id);
    }

    @DeleteMapping("{airport_id}")
    public void delete(@PathVariable Long airport_id) {
        service.delete(airport_id);
    }

    @GetMapping("{country}/{city}/airport_Geo")
    public Airport getAirportByAirportGeo(@PathVariable String country, @PathVariable String city){
        return service.getAirportByAirportGeo(country, city);
    }
}
