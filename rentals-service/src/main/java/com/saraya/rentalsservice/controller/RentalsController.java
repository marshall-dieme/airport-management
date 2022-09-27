package com.saraya.rentalsservice.controller;

import com.saraya.rentalsservice.bean.Rentals;
import com.saraya.rentalsservice.dto.RentalsDto;
import com.saraya.rentalsservice.service.RentalsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Rentals")
public class RentalsController {

    private final RentalsService service;

    public RentalsController(RentalsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rentals> getAll(){
        return service.getAll();
    }

    @GetMapping("/{name}")
    public int idRentals(@PathVariable("name") String name){
        return service.getId(name);
    }

    @PostMapping
    public Rentals create(@RequestBody RentalsDto dto){
        return service.create(dto);
    }

    @PostMapping("/passenger/{rentalsId}/{passportNo}")
    public Rentals putPassengerForRentals(@PathVariable("rentalsId") int rentalsId, @PathVariable("passportNo") int passportNo){
        return service.putPassengerForRentals(rentalsId, passportNo);
    }
}
