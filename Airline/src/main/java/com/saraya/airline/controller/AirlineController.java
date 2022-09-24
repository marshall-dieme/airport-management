package com.saraya.airline.controller;

import com.saraya.airline.model.Airline;
import com.saraya.airline.service.AirlineService;
import com.saraya.airline.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService service;

    @PostMapping("/")
    public Airline save(@RequestBody Airline airline){
        return service.create(airline);
    }

    @GetMapping("/{airline_id}")
    public ResponseTemplateVo getAirlineWithAirport(@PathVariable long airline_id){
        return service.getAirlineWithAirport(airline_id);
    }

    @GetMapping("/")
    public List<Airline> getAll(){
        return service.findAll();
    }

    @PutMapping
    public Airline update(@RequestBody Airline airline){
        return service.update(airline);
    }

    @DeleteMapping("/{airline_id}")
    public  void delete(@PathVariable long airline_id){
        service.delete(airline_id);
    }

}
