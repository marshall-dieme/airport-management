package com.saraya.microservice.airlineservice.controller;


import com.saraya.microservice.airlineservice.bean.Airline;
import com.saraya.microservice.airlineservice.service.AirlineService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aln")
public class AirlineController {
    private final AirlineService service ;

    public AirlineController(AirlineService service) {
        this.service = service;
    }


    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Airline getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public Airline create(@RequestBody Airline arpg) {
        return service.create(arpg);
    }

    @PutMapping
    public Airline update(@RequestBody Airline arpg) {
        return service.update(arpg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    /*@GetMapping("/country/{country}")
    public AirportGeo getIdDept(@PathVariable String country)
    {
        return service.getIdArp(country);
    }
*/
}
