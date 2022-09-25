package com.spring.passengersservices.controller;

import com.spring.passengersservices.bean.Passenger;
import com.spring.passengersservices.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PassengerController {
    @Autowired
    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }
    @GetMapping
    public List<Passenger> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Passenger> getById(@PathVariable int id){
        return service.getById(id);
    }
    @PostMapping
    public Passenger create(@RequestBody Passenger passenger){
        return service.create(passenger);
    }

    @PutMapping
    public Passenger update(@RequestBody Passenger passenger){
        return service.update(passenger);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
