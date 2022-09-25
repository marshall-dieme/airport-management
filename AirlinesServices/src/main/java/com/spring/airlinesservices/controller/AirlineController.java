package com.spring.airlinesservices.controller;


import com.spring.airlinesservices.DTO.AirlineDto;
import com.spring.airlinesservices.bean.Airline;
import com.spring.airlinesservices.sercice.AirlineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airline")
public class AirlineController {

    private final AirlineService service;

    public AirlineController(AirlineService service) {
        this.service = service;
    }


    @GetMapping
    public List<Airline> getAll(){
        return service.getAll();
    }

    public Optional<Airline> getById(int id){
        return service.getById(id);
    }

    @PostMapping
    public Airline create(@RequestBody AirlineDto airlineDto){
        return service.create(airlineDto);
    }

     @PutMapping
     public Airline update(@RequestBody AirlineDto airlineDto) {
       return service.update(airlineDto);
}

     @DeleteMapping("/{id}")
      public void delete(@PathVariable int id){
        service.delete(id);
}
}
