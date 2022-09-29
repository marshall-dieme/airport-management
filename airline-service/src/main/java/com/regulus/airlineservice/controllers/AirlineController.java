package com.regulus.airlineservice.controllers;

import com.regulus.airlineservice.dtos.AirlineDto;
import com.regulus.airlineservice.models.Airline;
import com.regulus.airlineservice.services.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    private final AirlineService serviceAirline;

    public AirlineController(AirlineService serviceAirline) {
        this.serviceAirline = serviceAirline;
    }

    @GetMapping
    public List<Airline> getAirlineList(){
        return serviceAirline.getAirline();
    }

    @PostMapping
    public AirlineDto create(@RequestBody AirlineDto airlineDto){
        return serviceAirline.createAirline(airlineDto);
    }

    @PutMapping("/{id}")
    public AirlineDto update(@PathVariable("id") int id, @RequestBody AirlineDto airlineDto){
        return serviceAirline.updateAirline(airlineDto, id);
    }

    @GetMapping("/{id}")
    public AirlineDto getAirline(@PathVariable("id") int id ){
        return serviceAirline.getAirline(id);
    }

    @GetMapping("/airlineName/{airlineName}")
    public Integer getAirlineByName(@PathVariable("airlineName") String airlineName){
        return serviceAirline.getAirlineId(airlineName);
    }

    @DeleteMapping("/{id}")
    public void deleteAirline(@PathVariable("id") int id){
        serviceAirline.deleteAirline(id);
    }


}
