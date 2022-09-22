package com.saraya.airline.controller;

import com.saraya.airline.model.Airline;
import com.saraya.airline.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airline")
public class AirlineController {

    private  final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }
    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

    @GetMapping("/{airline_name}")
        public Long getIdAirline(@PathVariable String airline_name ){
        return service.getIdAirline(airline_name);
        }

        @PostMapping
    public Airline create(@RequestBody Airline airline){
        return service.create(airline);
        }

        @PutMapping
    public Airline update(@RequestBody Airline airline){
        return service.update(airline);
        }
        @DeleteMapping("/delete/{airline_id}")
    public  void deleteBYId(@PathVariable Long airline_id){
        service.deleteById(airline_id);
        }
}
