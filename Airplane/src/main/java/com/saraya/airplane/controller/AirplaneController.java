package com.saraya.airplane.controller;


import com.saraya.airplane.model.Airplane;
import com.saraya.airplane.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    @Autowired
    private AirplaneService service;

    @PostMapping
    public Airplane save(@RequestBody Airplane airplane){
        return service.create(airplane);
    }

    @GetMapping("/{airplane_id}")
    public Airplane getById(@PathVariable long airplane_id){
        return service.findAirplaneById(airplane_id);
    }

    @GetMapping
    public List<Airplane> getAll(){
        return service.findAll();
    }

    @PutMapping
    public Airplane update(@RequestBody Airplane airplane){
        return service.update(airplane);
    }

    @DeleteMapping("/{airplane_id}")
    public void delete(@PathVariable long airplane_id){
        service.deleteById(airplane_id);
    }
}
