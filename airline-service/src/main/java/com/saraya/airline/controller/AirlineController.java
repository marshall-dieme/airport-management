package com.saraya.airline.controller;

import com.saraya.airline.model.Airline;
import com.saraya.airline.model.AirlineDto;
import com.saraya.airline.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("airline")
public class AirlineController {
    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }
    @GetMapping
    public List<Airline> getAll(){
        return service.getAllAirline();
    }

    @GetMapping("/{airline_id}")
    public  Airline getById(@PathVariable Long airline_id){
        return service.getAirlineId(airline_id);
    }

    @PostMapping
    public Airline create(@RequestBody AirlineDto dto){

        return service.createAirline(dto);
    }


     @PutMapping
    public Airline edit (@RequestBody AirlineDto dto){
        return service.updateAirline(dto);
     }

     @DeleteMapping("/{airline_id}")
    public void delete(@PathVariable Long airline_id){
        service.deleteAirline(airline_id);
     }

    @GetMapping("/airline_name/iata/{airline_name}/{iata}")
    public Long getRec(@PathVariable String airline_name, @PathVariable String iata){
        return service.getAirlineId(airline_name,iata);
     }

}
