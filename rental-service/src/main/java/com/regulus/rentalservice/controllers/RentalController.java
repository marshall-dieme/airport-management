package com.regulus.rentalservice.controllers;


import com.regulus.rentalservice.dtos.RentalDto;
import com.regulus.rentalservice.models.Rental;
import com.regulus.rentalservice.services.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
public class RentalController {

    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<Rental> getRentalList(){
        return rentalService.getRental();
    }

    @PostMapping
    public RentalDto create(@RequestBody RentalDto rentalDto){
        return rentalService.createRental(rentalDto);
    }

    @PutMapping("/{id}")
    public RentalDto update(@PathVariable("id") int id, @RequestBody RentalDto rentalDto){
        return rentalService.updateRental(rentalDto, id);
    }

    @GetMapping("/{id}")
    public RentalDto getRental(@PathVariable("id") int id ){
        return rentalService.getRental(id);
    }

    @GetMapping("/name/{name}")
    public Integer getRentalId(@PathVariable("name") String name){
        return rentalService.getRentalId(name);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable("id") int id){
        rentalService.deleteRental(id);
    }
}
