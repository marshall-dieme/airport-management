package com.saraya.airplanetype.controller;

import com.saraya.airplanetype.model.AirplaneType;
import com.saraya.airplanetype.service.AirplaneTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airplanetype")
public class AirplaneTypeController {

    private final AirplaneTypeService service;

    public AirplaneTypeController(AirplaneTypeService service) {

        this.service = service;
    }
@GetMapping
    public List<AirplaneType> getAll(){

        return service.getAllAirplaneType();
    }

    @GetMapping("/{airplane_type_id}")
    public AirplaneType getByIdAirplaneType(@PathVariable Long airplane_type_id){

        return service.getByIdAirplaneType(airplane_type_id);
    }

    @PostMapping
    public AirplaneType create(@RequestBody AirplaneType airplaneType){
        return service.createAirplaneType(airplaneType);
    }

    @PutMapping
    public AirplaneType edit(@RequestBody AirplaneType airplaneType){

        return service.updateAirplaneType(airplaneType);
    }

    @DeleteMapping("/{airplane_type_id}")

    public void delete(@PathVariable Long airplane_type_id){
        service.deleteAirplaneType(airplane_type_id);
    }
}
