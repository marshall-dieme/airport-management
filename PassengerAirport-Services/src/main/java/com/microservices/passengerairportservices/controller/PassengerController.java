package com.microservices.passengerairportservices.controller;


import com.microservices.passengerairportservices.entity.Passenger;
import com.microservices.passengerairportservices.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Passenger> getAll(){
        return service.getAll();
    }

    @GetMapping("/{passengerId}")
    public Optional<Passenger> getById(@PathVariable Long passengerId) {
        return service.getById(passengerId);
    }

    @PostMapping("/create")
    public Passenger create(@RequestBody Passenger passenger) {
        return service.create(passenger);
    }

    @PutMapping
    public Passenger update(@RequestBody Passenger passenger) {
        return service.update(passenger);
    }

    @DeleteMapping("/{passengerId}")
    public void delete(@PathVariable Long passengerId) {
        service.delete(passengerId);
    }

    @GetMapping("/NumberPassport/{NumberPassport}")
    public String getIdPassenger(@PathVariable String NumberPassport) {
        return service.getIdPassenger(NumberPassport);
    }

}
