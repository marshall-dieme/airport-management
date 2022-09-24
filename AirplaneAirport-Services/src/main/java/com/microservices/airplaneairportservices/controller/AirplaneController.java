package com.microservices.airplaneairportservices.controller;


import com.microservices.airplaneairportservices.entity.Airplane;
import com.microservices.airplaneairportservices.entity.AirplaneDTO;
import com.microservices.airplaneairportservices.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{airplane_id}")
    public Optional<Airplane> getById(@PathVariable Long airplane_id) {
        return service.getById(airplane_id);
    }

    @PostMapping("/create")
    public Airplane create(@RequestBody AirplaneDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public Airplane update(@RequestBody AirplaneDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{airplane_id}")
    public void delete(@PathVariable Long airplane_id) {
        service.delete(airplane_id);
    }

    @GetMapping("/{airlineName}/serviceairplane")
    public List<Airplane> findAirlineByAirplane(@PathVariable String airlineName){
        return service.findAirlineByAirplane(airlineName);
    }
}
