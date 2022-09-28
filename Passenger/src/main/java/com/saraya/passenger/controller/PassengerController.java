package com.saraya.passenger.controller;

import com.saraya.passenger.model.Passenger;
import com.saraya.passenger.model.PassengerDto;
import com.saraya.passenger.service.PassengerService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    private final PassengerService service;

    public PassengerController(PassengerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Passenger> getAll(){
        return  service.getAll();
    }
    @GetMapping("/{passport_no}")
    public Long getById(@PathVariable int passport_no){
        return service.getById(passport_no);
    }

    @PostMapping("/")
    public Passenger create(@RequestBody PassengerDto dto){
        return service.create(dto);
    }

    @PutMapping("/")
    public Passenger update(@RequestBody PassengerDto dto){
        return service.update(dto);
    }

    @DeleteMapping("/{passenger_id}")
    public void deleteById(@PathVariable Long passenger_id){
        service.deleteById(passenger_id);
    }

    @GetMapping("/email/{email}/passengerDetails")
    public Passenger  getPassengerByPassengerDetails(@PathVariable String email){
        return service.getPassengerByPassengerDetails(email);
    }
}
