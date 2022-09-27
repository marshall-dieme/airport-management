package com.saraya.airplaneservice.controller;

import com.saraya.airplaneservice.model.Airplane;
import com.saraya.airplaneservice.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airplane")
public class AirplaneController {

    private final AirplaneService service;

    public AirplaneController(AirplaneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airplane> getAll(){
        return service.getAllAirplane();
    }

    @GetMapping("/{airplane_id}")
 public Airplane getById(@PathVariable Long airplane_id){
        return service.GetByIdAirplane(airplane_id);
    }
    @PostMapping
    public Airplane create(@RequestBody Airplane airplane){
        return service.createAirplane(airplane);
    }
    @PutMapping
    public Airplane edit(@RequestBody Airplane airplane){
        return service.updateAirplane(airplane);
    }

    @DeleteMapping("/{airplane_id}")
    public void delete(@PathVariable Long airplane_id){
        service.deleteAirplane(airplane_id);
    }
}
