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

   @GetMapping("/airportName/{airport_name}")
    public Long getIdAirport(@PathVariable String airport_name){
       return service.getAirportId(airport_name);
   }



    @GetMapping("/{city}/{country}/geo")
    public Airport getAirportByAirportGeo(@PathVariable String city,@PathVariable String country) {
        return service.getAirportByAirportGeo(city, country);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDto dto) {
        return service.create(dto);
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
