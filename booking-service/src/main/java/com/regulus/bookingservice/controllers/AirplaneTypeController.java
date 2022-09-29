package com.regulus.airplanetypeservice.controllers;

import com.regulus.airplanetypeservice.dtos.AirplaneTypeDto;
import com.regulus.airplanetypeservice.models.AirplaneType;
import com.regulus.airplanetypeservice.services.AirplaneTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplane-type")
public class AirplaneTypeController {

    private final AirplaneTypeService serviceAirplaneType;

    public AirplaneTypeController(AirplaneTypeService serviceAirplaneType) {
        this.serviceAirplaneType = serviceAirplaneType;
    }

    @GetMapping
    public List<AirplaneType> getAirplaneTypeList(){
        return serviceAirplaneType.getAirplaneType();
    }

    @PostMapping
    public AirplaneTypeDto create(@RequestBody AirplaneTypeDto airplaneTypeDto){
        return serviceAirplaneType.createAirplaneType(airplaneTypeDto);
    }

    @PutMapping("/{id}")
    public AirplaneTypeDto update(@PathVariable("id") int id, @RequestBody AirplaneTypeDto airplaneTypeDto){
        return serviceAirplaneType.updateAirplaneType(airplaneTypeDto, id);
    }

    @GetMapping("/{id}")
    public AirplaneTypeDto getAirplaneType(@PathVariable("id") int id ){
        return serviceAirplaneType.getAirplaneType(id);
    }

    @GetMapping("/identifier/{identifier}")
    public Integer getAirplaneTypeId(@PathVariable("identifier") String identifier){
        return serviceAirplaneType.getAirplaneTypeId(identifier);
    }

    @DeleteMapping("/{id}")
    public void deleteAirplaneType(@PathVariable("id") int id){
        serviceAirplaneType.deleteAirplaneType(id);
    }

}
