package com.saraya.passenger.controller;

import com.saraya.passenger.bean.Passenger;
import com.saraya.passenger.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public Passenger create(@RequestBody Passenger passenger){
        return service.create(passenger);
    }

    @PutMapping("/{id}")
    public Passenger update(int id, @RequestBody Passenger passenger){
        return service.update(passenger);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
