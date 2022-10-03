package com.saraya.microservicerentals.controllers;

import com.saraya.microservicerentals.dto.RentalsDto;
import com.saraya.microservicerentals.exceptions.ResourceNotFoundException;
import com.saraya.microservicerentals.mappers.RentalsMapper;
import com.saraya.microservicerentals.models.Rentals;
import com.saraya.microservicerentals.services.RentalsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rentalss")
public class RentalsController {
    private final RentalsService rentalsService;
    private final RentalsMapper rentalsMapper;

    public RentalsController(RentalsService rentalsService, RentalsMapper rentalsMapper) {
        this.rentalsService = rentalsService;
        this.rentalsMapper = rentalsMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RentalsDto rentalsDto) throws ResourceNotFoundException {

        Rentals rentals = rentalsService.add(rentalsMapper.rentalsDtoToRentals(rentalsDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalsMapper.rentalsToRentalsDto(rentals));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Rentals> rentalsList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Rentals> rentalsPage = this.rentalsService.getRentalss(pageable);
        rentalsList = rentalsPage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("rentals",this.rentalsMapper.rentalssToRentalsDtos(rentalsList));
        response.put("currentPage",rentalsPage.getNumber());
        response.put("totalItems",rentalsPage.getTotalElements());
        response.put("totalPages",rentalsPage.getTotalPages());

        if (rentalsList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<RentalsDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Rentals rentals = this.rentalsService.getRentals(id);

        return new ResponseEntity<RentalsDto>(this.rentalsMapper.rentalsToRentalsDto(rentals),HttpStatus.OK);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@RequestBody RentalsDto rentalsDto, @PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        Rentals rentals = rentalsService.update(rentalsMapper.rentalsDtoToRentals(rentalsDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalsMapper.rentalsToRentalsDto(rentals));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.rentalsService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
