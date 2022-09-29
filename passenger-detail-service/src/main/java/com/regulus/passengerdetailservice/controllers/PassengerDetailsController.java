package com.regulus.passengerdetailservice.controllers;

import com.regulus.passengerdetailservice.dtos.PassengerDetailsDto;
import com.regulus.passengerdetailservice.models.PassengerDetails;
import com.regulus.passengerdetailservice.services.PassengerDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengerDetails")
public class PassengerDetailsController {

    private final PassengerDetailsService service;

    public PassengerDetailsController(PassengerDetailsService service) {
        this.service = service;
    }

    @GetMapping
    public List<PassengerDetails> getPassengerDetailsList(){
        return service.getPassengerDetails();
    }

    @PostMapping
    public PassengerDetailsDto create(@RequestBody PassengerDetailsDto detailsDto){
        return service.createPassengerDetails(detailsDto);
    }

    @PutMapping("/{id}")
    public PassengerDetailsDto update(@PathVariable("id") int id, @RequestBody PassengerDetailsDto detailsDto){
        return service.updatePassengerDetails(detailsDto, id);
    }

    @GetMapping("/{id}")
    public PassengerDetailsDto getPassengerDetails(@PathVariable("id") int id ){
        return service.getPassengerDetails(id);
    }

    @DeleteMapping("/{id}")
    public void deletePassengerDetails(@PathVariable("id") int id){
        service.deletePassengerDetails(id);
    }
}
