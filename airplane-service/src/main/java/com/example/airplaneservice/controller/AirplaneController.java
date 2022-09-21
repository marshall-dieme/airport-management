package com.example.airplaneservice.controller;

import com.example.airplaneservice.model.Airplane;
import com.example.airplaneservice.model.AirplaneDto;
import com.example.airplaneservice.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {
    private final AirplaneService service;

    public AirplaneController(AirplaneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airplane> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Airplane> getById(@PathVariable Long id) {
        return service.getById(id);
    }
   /* @GetMapping("/{name}")
    public Airplane getByCity(String name){
        return service.getByAirplaneName(name);
    }*/


    @PostMapping
    public Airplane create(@RequestBody AirplaneDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Airplane update(@RequestBody AirplaneDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
