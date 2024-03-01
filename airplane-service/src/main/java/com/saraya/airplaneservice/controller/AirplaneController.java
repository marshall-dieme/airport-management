package com.saraya.airplaneservice.controller;

import com.saraya.airplaneservice.bean.Airplane;
import com.saraya.airplaneservice.dto.AirplaneDto;
import com.saraya.airplaneservice.service.AirplaneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Airplane")
public class AirplaneController {

    @PostMapping("/airline/{airplaneId}/{airlineName}")
    public Airplane putAirlineForAirplane(@PathVariable("airplaneId") int airplaneId, @PathVariable("airlineName") String airlineName){
        return service.putAirlineForAirplane(airplaneId, airlineName);
    }

    @PostMapping("/flight/{airplaneId}/{flightNo}")
    public Airplane putFlightForAirplane(@PathVariable("airplaneId") int airplaneId, @PathVariable("flightNo") String flightNo){
        return service.putFlightForAirplane(airplaneId, flightNo);
    }

    @PostMapping("/airplaneType/{airplaneId}/{identifierAirplaneType}")
    public Airplane putAirPlaneTypeForAirplane(@PathVariable("airplaneId") int airplaneId,
                                               @PathVariable("identifierAirplaneType") String identifierAirplaneType){
        return service.putAirPlaneTypeForAirplane(airplaneId, identifierAirplaneType);
    }

    @GetMapping("/{capacity}")
    public int getIdByCapacity(@PathVariable("capacity") int capacity){
        return service.getIdByCapacity(capacity);
    }

    private final AirplaneService service;

    public AirplaneController(AirplaneService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airplane> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Airplane create(@RequestBody AirplaneDto dto){
        return service.create(dto);
    }

    @PutMapping
    public Airplane update(@RequestBody AirplaneDto dto){
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody AirplaneDto dto){
        service.delete(dto);
    }

}
