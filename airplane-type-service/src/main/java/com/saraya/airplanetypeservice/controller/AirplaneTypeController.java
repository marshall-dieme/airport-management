package com.saraya.airplanetypeservice.controller;

import com.saraya.airplanetypeservice.bean.AirplaneType;
import com.saraya.airplanetypeservice.dto.AirplaneTypeDto;
import com.saraya.airplanetypeservice.service.AirplaneTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AirplaneType")
public class AirplaneTypeController {

    private final AirplaneTypeService service;

    public AirplaneTypeController(AirplaneTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<AirplaneType> getAll(){
        return service.getAll();
    }

    @GetMapping("/{identifier}")
    public int getId(@PathVariable("identifier") String identifier){
        return service.getId(identifier);
    }

    @PostMapping
    public AirplaneType create(@RequestBody AirplaneTypeDto dto){
        return service.create(dto);
    }

    @PostMapping("/airplane/{airplaneTypeId}/{airplaneCapacity}")
    public AirplaneType putAirplaneForAirline(@PathVariable("airplaneTypeId") int airplaneTypeId, @PathVariable("airplaneCapacity") int airplaneCapacity){
        return service.putAirplaneForAirplaneType(airplaneTypeId, airplaneCapacity);
    }
}
