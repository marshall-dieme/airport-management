package com.saraya.airplaneservice.controller;

import com.saraya.airplaneservice.model.Airplane;
import com.saraya.airplaneservice.model.AirplaneDTO;
import com.saraya.airplaneservice.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane")
public class AirplaneController {

    private final AirplaneService service;

    public AirplaneController(AirplaneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airplane> getAll(){
        return service.getAll();
    }

    @GetMapping("/{capacity}")
    public Airplane getByCapacity(
            @PathVariable String capacity){
        return service.getByCapacity(capacity);
    }

    @PostMapping
    public Airplane create(@RequestBody AirplaneDTO airplane){
        return service.create(airplane);
    }

    @PutMapping
    public Airplane update(@RequestBody Airplane airplane){
        return service.update(airplane);
    }

    @DeleteMapping("delete/{capacity}")
    public void deleteByCapacity(
            @PathVariable String capacity){
        service.deleteByCapacity(capacity);
    }

    @DeleteMapping("/{airplane_id}")
    public void deleteById(@PathVariable int airplane_id){
        service.deleteById(airplane_id);
    }

}
