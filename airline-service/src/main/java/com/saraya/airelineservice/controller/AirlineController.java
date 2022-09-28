package com.saraya.airelineservice.controller;

import com.saraya.airelineservice.model.Airline;
import com.saraya.airelineservice.model.AirlineDTo;
import com.saraya.airelineservice.service.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airlines")
public class AirlineController {
    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

   /* @GetMapping("/{name}")
    public Airline getByCity(String name){
        return service.getByName(name);
    }*/


    @GetMapping("/airlineName/{airline_name}")
    public Long getIdAirportGeo(@PathVariable String airline_name){
        return service.getIdAirline(airline_name);
    }

    @GetMapping("/{airport_name}/airports")
    public List <Airline>  getAirlinesByAirport(@PathVariable String airport_name) {
        return service.getAirlinesByAirport(airport_name);
    }


    @PostMapping("/")
    public Airline create(@RequestBody AirlineDTo dto) {

        return service.create(dto);
    }

    @PutMapping("/")
    public Airline update (@RequestBody AirlineDTo dto){
        return service.update(dto);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
