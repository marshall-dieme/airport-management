package com.saraya.airplane.controller;


import com.saraya.airplane.model.Airplane;
import com.saraya.airplane.model.AirplaneDto;
import com.saraya.airplane.service.AirplaneService;
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
    public List<Airplane> getAll() {
        return service.getAll();
    }

    @GetMapping("capacity/{capacity}")
    public Long getByName(@PathVariable String capacity) {
        return service.getIdAirplane(capacity);
    }

    @PostMapping
    public Airplane create(@RequestBody AirplaneDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Airplane update(@RequestBody  AirplaneDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("{airplane_id}")
    public void delete(@PathVariable Long airplane_id) {
        service.deleteById(airplane_id);
    }

    @GetMapping("{airlineName}/airlineName")
    public List<Airplane> getAirplaneByAirline(@PathVariable String  airlineName){
        return service.getAirplaneByAirline(airlineName);
    }

}

