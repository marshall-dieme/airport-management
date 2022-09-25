package com.spring.passengersdetails.controller;


import com.spring.passengersdetails.bean.PassengerDetails;
import com.spring.passengersdetails.service.PassengerDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passangersDetais")
public class PassengerDetailsController {

    private final PassengerDetailsService service;

    public PassengerDetailsController(PassengerDetailsService service) {
        this.service = service;
    }
    @GetMapping
    public List<PassengerDetails> getAll(){
        return service.getAll();
    }
    public Optional<PassengerDetails> getById(int id){
        return service.getById(id);
    }

    @PostMapping
    public PassengerDetails create(@RequestBody PassengerDetails passenger){
        return service.create(passenger);
    }

    @PutMapping
    public PassengerDetails update( @RequestBody PassengerDetails passenger){
        return service.update(passenger);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
