package com.saraya.airlineservice.controller;

import com.saraya.airlineservice.model.Airline;
import com.saraya.airlineservice.model.AirlineDto;
import com.saraya.airlineservice.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

   /* @GetMapping("/{name}")
    public Airline getByCity(String name){
        return service.getByName(name);
    }*/


    @GetMapping("/airlineName/{airline_name}")
    public Long getIdAirportGeo(@PathVariable String airline_name){
        return service.getIdAirline(airline_name);
    }


    @PostMapping("/")
    public Airline create(@RequestBody AirlineDto dto) {

        return service.create(dto);
    }

    @PutMapping("/")
    public Airline update (@RequestBody AirlineDto dto){
        return service.update(dto);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
