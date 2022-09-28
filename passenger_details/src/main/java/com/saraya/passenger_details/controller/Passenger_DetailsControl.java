package com.saraya.passenger_details.controller;

import com.saraya.passenger_details.dtos.Passenger_DetailsDto;
import com.saraya.passenger_details.model.PassengerDetails;
import com.saraya.passenger_details.service.Passenger_DetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger_details")
public class Passenger_DetailsControl {
    private final Passenger_DetailsService service ;


    public Passenger_DetailsControl(Passenger_DetailsService service) {
        this.service = service;
    }


    @GetMapping
    public List<PassengerDetails> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PassengerDetails getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PassengerDetails create(@RequestBody Passenger_DetailsDto passengerDetails) {
        return service.create(passengerDetails);
    }

    @PutMapping
    public PassengerDetails update(@RequestBody PassengerDetails passengerDetails) {
        return service.update(passengerDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
