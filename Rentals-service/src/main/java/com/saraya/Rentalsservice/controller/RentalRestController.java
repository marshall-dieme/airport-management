package com.saraya.Rentalsservice.controller;

import com.saraya.Rentalsservice.dto.RentalsDto;
import com.saraya.Rentalsservice.model.Rentals;
import com.saraya.Rentalsservice.service.RentalsServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("rentals")
public class RentalRestController {

    private final RentalsServiceImpl rentalsService;


    @GetMapping
    public ResponseEntity<List<RentalsDto>> getAllRentals() {
        return ResponseEntity.ok(rentalsService.getAllRentals());
    }

    @GetMapping("/{rental_id}")
    public ResponseEntity<RentalsDto> getRentals(@PathVariable Long rental_id) {
        return ResponseEntity.ok(rentalsService.getRentalById(rental_id));
    }

    @PostMapping
    public ResponseEntity<Rentals> saveRental(@RequestBody RentalsDto dto) {
        return new ResponseEntity<>(rentalsService.saveRental(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Rentals> updateRental(@RequestBody RentalsDto dto) {
        return ResponseEntity.ok(rentalsService.updateRental(dto));
    }

    @DeleteMapping("/{rental_id}")
    public ResponseEntity<String> deleteRental(@PathVariable Long rental_id) {
        rentalsService.deleteRental(rental_id);
        return ResponseEntity.ok("Rental "+rental_id+ "was deleted successfully");
    }
}
