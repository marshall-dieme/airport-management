package com.regulus.passengerservice.controllers;


import com.regulus.passengerservice.dtos.PassengerDto;
import com.regulus.passengerservice.models.Passenger;
import com.regulus.passengerservice.services.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<Passenger> getPassengerList(){
        return passengerService.getPassenger();
    }

    @PostMapping
    public PassengerDto create(@RequestBody PassengerDto passengerDto){
        return passengerService.createPassenger(passengerDto);
    }

    @PutMapping("/{id}")
    public PassengerDto update(@PathVariable("id") int id, @RequestBody PassengerDto passengerDto){
        return passengerService.updatePassenger(passengerDto, id);
    }

    @GetMapping("/{id}")
    public PassengerDto getPassenger(@PathVariable("id") int id ){
        return passengerService.getPassenger(id);
    }

    @GetMapping("/passport/{passport}")
    public Integer getPassengerId(@PathVariable("passport") String passport){
        return passengerService.getPassengerId(passport);
    }

    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable("id") int id){
        passengerService.deletePassenger(id);
    }

}
