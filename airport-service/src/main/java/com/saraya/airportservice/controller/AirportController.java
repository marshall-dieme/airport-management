package com.saraya.airportservice.controller;

import com.saraya.airportservice.model.Airport;
import com.saraya.airportservice.model.AirportDto;
import com.saraya.airportservice.services.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }



    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Airport> getById(@PathVariable Long id) {
        return service.getById(id);
    }
   /* @GetMapping("/{name}")
    public Airport getByCity(String name){
        return service.getByAirportName(name);
    }*/

    @PostMapping
    public Airport create(@RequestBody AirportDto emp) {
        return service.create(emp);
    }

    @PutMapping
    public Airport update(@RequestBody AirportDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
