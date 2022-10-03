package com.saraya.passengerdetails.controller;

import com.saraya.passengerdetails.dto.PassengerDetailsDto;
import com.saraya.passengerdetails.model.PassengerDetails;
import com.saraya.passengerdetails.service.PassengerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passengerDetails")
public class PassengerDetailsController {
    @Autowired
    private PassengerDetailsService service;

    @GetMapping
    public List<PassengerDetails> getAll(){
        return service.getAllPassengerDetails();
    }

    @GetMapping("{passenger_detail_id}")
    public PassengerDetails getById(@PathVariable Long passenger_details_id){
        return service.getByIdPassengerDetails(passenger_details_id);
    }
    @PostMapping
    public PassengerDetails create(@RequestBody PassengerDetailsDto passengerDetailsDto){
        return service.createPassengerDetails(passengerDetailsDto);

    }

    @PutMapping
    public PassengerDetails edit(@RequestBody PassengerDetailsDto passengerDetails){
        return service.updatePassengerDetails(passengerDetails);
    }
}
