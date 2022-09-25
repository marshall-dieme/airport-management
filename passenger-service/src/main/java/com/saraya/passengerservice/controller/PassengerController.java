package com.saraya.passengerservice.controller;

import com.saraya.passengerservice.bean.Passenger;
import com.saraya.passengerservice.dto.PassengerDto;
import com.saraya.passengerservice.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Passenger")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Passenger> getAll(){
        return service.getAll();
    }

    @GetMapping("/{passportNo}")
    public int idPassenger(@PathVariable("passportNo") String passportNo){
        return service.getId(passportNo);
    }

    @PostMapping
    public Passenger create(@RequestBody PassengerDto dto){
        return service.create(dto);
    }

    @PostMapping("/booking/{passengerId}/{priceBooking}")
    public Passenger putbookingForPassenger(@PathVariable("passengerId") int passengerId, @PathVariable("priceBooking") int priceBooking){
        return service.putbookingForPassenger(passengerId, priceBooking);
    }

    @PostMapping("/parking/{passengerId}/{parkingName}")
    public Passenger putparckingForPassenger(@PathVariable("passengerId") int passengerId, @PathVariable("parkingName") String parkingName){
        return service.putparckingForPassenger(passengerId, parkingName);
    }

}
