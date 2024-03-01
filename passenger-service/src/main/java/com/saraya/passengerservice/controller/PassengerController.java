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

    @PostMapping("/rentals/{passengerId}/{rentalsName}")
    public Passenger putRentalsForPassenger(@PathVariable("passengerId") int passengerId, @PathVariable("rentalsName") String rentalsName){
        return service.putRentalsForRentals(passengerId, rentalsName);
    }

    @PostMapping("/passengerDetails/{passengerId}/{emailPassengerDetail}")
    public Passenger putPassengerDetailsForPassenger(@PathVariable("passengerId") int passengerId, @PathVariable("emailPassengerDetail") String emailPassengerDetail){
        return service.putPassengerDetailsForPassenger(passengerId, emailPassengerDetail);
    }

    @GetMapping("/{passportNo}")
    public int idPassenger(@PathVariable("passportNo") String passportNo){
        return service.getId(passportNo);
    }

    @GetMapping
    public List<Passenger> getAll(){
        return service.getAll();
    }

    @PutMapping
    public Passenger update(@RequestBody PassengerDto dto){
        return service.update(dto);
    }

    @DeleteMapping
    public void delete(@RequestBody PassengerDto dto){
        service.delete(dto);
    }

}
