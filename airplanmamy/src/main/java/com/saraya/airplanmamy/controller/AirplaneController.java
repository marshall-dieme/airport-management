package com.saraya.airplanmamy.controller;

import com.saraya.airplanmamy.bean.Airplane;
import com.saraya.airplanmamy.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {
    @Autowired
    private final AirplaneService service;

    public AirplaneController(AirplaneService service) {
        this.service = service;
    }
    @GetMapping
    public List<Airplane> getAll(){
        return  service.getAll();
    }
    @PostMapping
    public Airplane create( @RequestBody Airplane airplane){
        return service.create(airplane);


    }
    @PutMapping
    public Airplane update( @RequestBody Airplane airplane){
        return service.update(airplane);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    }
