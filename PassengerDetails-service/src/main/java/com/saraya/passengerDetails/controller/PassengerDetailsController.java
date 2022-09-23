package com.saraya.passengerDetails.controller;

import com.saraya.passengerDetails.bean.PassengerDetails;
import com.saraya.passengerDetails.service.PassengerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PassengerDetailsController {
    @Autowired
    private final PassengerDetailsService service;

    public PassengerDetailsController(PassengerDetailsService service) {
        this.service = service;
    }
    @GetMapping
    public List<PassengerDetails> getAll(){
        return service.getAll();
    }

    @PostMapping
    public PassengerDetails create(@RequestBody PassengerDetails passenger){
        return service.create(passenger);
    }

    @PutMapping("/{id}")
    public PassengerDetails update(int id, @RequestBody PassengerDetails passenger){
        return service.update(passenger);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
