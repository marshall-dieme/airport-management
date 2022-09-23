package com.saraya.airplanetypeservice.controller;


import com.saraya.airplanetypeservice.model.AirplaneType;
import com.saraya.airplanetypeservice.service.AirplaneTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplaneType")
public class AirplaneTypeController {

    private final AirplaneTypeService service;

    public AirplaneTypeController(AirplaneTypeService service) {
        this.service = service;
    }
    @GetMapping
    public List<AirplaneType> getAll(){
        return service.getAll();
    }

    @GetMapping("/get/{airplaneTypeIdentifier}")
    public AirplaneType getByAirplaneTypeIdentifier(
            @PathVariable String airplaneTypeIdentifier){
        return service.getByAirplaneTypeIdentifier(airplaneTypeIdentifier);
    }

    @PostMapping
    public AirplaneType create(@RequestBody AirplaneType airplaneType){
        return service.create(airplaneType);
    }

    @PutMapping
    public AirplaneType update(@RequestBody AirplaneType airplaneType){
        return service.update(airplaneType);
    }

    @DeleteMapping("delete/{airplaneTypeIdentifier}")
    public void deleteByAirplaneTypeIdentifier(
            @PathVariable String airplaneTypeIdentifier ){
        service.deleteByAirplaneTypeIdentifier(airplaneTypeIdentifier);
    }


    @DeleteMapping("/{airplaneTypeId}")
    public void deleteById(@PathVariable int airplaneTypeId){
        service.deleteById(airplaneTypeId);
    }

    @GetMapping("/{airplaneTypeIdentifier}")
    public Integer findByAirplaneTypeIdentifier(
            @PathVariable String airplaneTypeIdentifier) {
        return  service.findByAirplaneTypeIdentifier(airplaneTypeIdentifier).getAirplaneId();
    }

}
