package com.saraya.passenger.controller;

import com.saraya.passenger.model.Passenger;
import com.saraya.passenger.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }
    @GetMapping
    public List<Passenger> getAll(){
        return service.getAll();
    }
    @GetMapping("/passport_no/firstname/lastname/{passport_no}/{firstname}/{lastname}")
    public Double getIdPassenger(@PathVariable String passport_no, @PathVariable String firstname, @PathVariable String  lastname){
        return service.getIdPassenger(passport_no, firstname, lastname);
    }
    @PostMapping("/")
    public Passenger create(@RequestBody Passenger passenger){
        return service.create(passenger);
    }
    @PutMapping("/")
    public Passenger update(@RequestBody Passenger passenger){
        return service.update(passenger);
    }
    public void deleteById(Double id){
        service.delete(id);
    }
    public  void deleteByName(String passport_no, String firstname, String lastname){
        service.deleteByPassport_noAndFirstnameAndLastname(passport_no, firstname, lastname);
    }
}
