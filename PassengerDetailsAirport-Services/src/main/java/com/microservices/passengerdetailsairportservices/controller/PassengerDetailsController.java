package com.microservices.passengerdetailsairportservices.controller;

import com.microservices.passengerdetailsairportservices.entity.PassengerDetails;
import com.microservices.passengerdetailsairportservices.entity.PassengerDetailsDTO;
import com.microservices.passengerdetailsairportservices.service.PassengerDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/passengerdetails")
public class PassengerDetailsController {

    private final PassengerDetailsService service;

    public PassengerDetailsController(PassengerDetailsService service) {
        this.service = service;
    }

    @GetMapping
    public List<PassengerDetails> getAll(){
        return service.getAll();
    }

    @GetMapping("/{passengerdetailsId}")
    public Optional<PassengerDetails> getById(@PathVariable Long passengerdetailsId) {
        return service.getById(passengerdetailsId);
    }

    @PostMapping
    public PassengerDetails create(@RequestBody PassengerDetailsDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public PassengerDetails update(@RequestBody PassengerDetailsDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{passengerdetailsId}")
    public void delete(@PathVariable Long passengerdetailsId) {
        service.deleteById(passengerdetailsId);
    }

    @GetMapping("/{NumberPassport}/findpassengerbyid")
    public PassengerDetails findPassengerByDetails(@PathVariable String NumberPassport){
        return service.findPassengerByDetails(NumberPassport);
    }
}
