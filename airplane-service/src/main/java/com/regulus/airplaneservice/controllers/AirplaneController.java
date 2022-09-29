package com.regulus.airplaneservice.controllers;

import com.regulus.airplaneservice.dtos.AirplaneDto;
import com.regulus.airplaneservice.models.Airplane;
import com.regulus.airplaneservice.services.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airplanes")
public class AirplaneController {

    private final AirplaneService serviceAirplane;

    public AirplaneController(AirplaneService serviceAirplane) {
        this.serviceAirplane = serviceAirplane;
    }

    @GetMapping
    public List<Airplane> getAirplaneList(){
        return serviceAirplane.getAirplane();
    }

    @PostMapping
    public AirplaneDto create(@RequestBody AirplaneDto airplaneDto){
        return serviceAirplane.createAirplane(airplaneDto);
    }

    @PutMapping("/{id}")
    public AirplaneDto update(@PathVariable("id") int id, @RequestBody AirplaneDto airplaneDto){
        return serviceAirplane.updateAirplane(airplaneDto, id);
    }

    @GetMapping("/{id}")
    public AirplaneDto getAirplane(@PathVariable("id") int id ){
        return serviceAirplane.getAirplane(id);
    }


    @DeleteMapping("/{id}")
    public void deleteAirplane(@PathVariable("id") int id){
        serviceAirplane.deleteAirplane(id);
    }

}
