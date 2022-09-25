package com.example.rentalsservice.controller;

import com.example.rentalsservice.model.Rental;
import com.example.rentalsservice.model.RentalDto;
import com.example.rentalsservice.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private  final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rental> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Rental> getById(@PathVariable Long RentalId) {
        return service.getById(RentalId);
    }


    @GetMapping("/passportNo/{passportNo}")
    public List <Rental> getRentalByPassenger(@PathVariable String passportNo) {
        return (List<Rental>) service.getRentalByPassenger(passportNo);
    }



    @PostMapping
    public Rental create(@RequestBody RentalDto dto) {
        return service.create(dto);
    }

    @PutMapping
    public Rental update(@RequestBody RentalDto dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
