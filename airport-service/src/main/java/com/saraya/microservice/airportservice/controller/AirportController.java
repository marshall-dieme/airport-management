package com.saraya.microservice.airportservice.controller;

import com.saraya.microservice.airportservice.model.Airport;
import com.saraya.microservice.airportservice.model.AirportDto;
import com.saraya.microservice.airportservice.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/arps")
public class AirportController {
    private final AirportService service ;

    public AirportController(AirportService service) {
        this.service = service;
    }
    @GetMapping
    public List<Airport> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Airport getById(@PathVariable int id) {
       return service.getById(id);
    }

    @PostMapping
    public Airport create(@RequestBody AirportDto arp) {
        return service.create(arp);
    }
    @PostMapping

    @PutMapping
    public Airport update(@RequestBody AirportDto arpt) {
        return service.update(arpt);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

   /*@GetMapping("/airport_name/{airport_name}")
    public Airport getIdDept(@PathVariable String airport_name) {
        return  service.getIdArp(airport_name);
    }*/
//    @GetMapping("/country/{country}")
//    public AirportGeo getIdDept(@PathVariable String country) {
//        return service.getIdArp(country);
//    }


}
