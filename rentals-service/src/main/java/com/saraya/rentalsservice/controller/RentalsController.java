package com.saraya.rentalsservice.controller;

import com.saraya.rentalsservice.model.Rentals;
import com.saraya.rentalsservice.service.RentalsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalsController {

    private final Logger LOGGER = LoggerFactory.getLogger(RentalsController.class);

    private final RentalsService service;

    public RentalsController(RentalsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rentals> getAll(){
        return service.getAll();
    }


    @GetMapping("/recup/{licenceNo}")
    public Rentals getByLicenceNo(
            @PathVariable String licenceNo){
        return service.getByLicenceNo(licenceNo);
    }

    @PostMapping
    public Rentals create(@RequestBody Rentals rentals){
        LOGGER.info("CREATING A NEW RENTALS...");
        return service.create(rentals);
    }

    @PutMapping
    public Rentals update(@RequestBody Rentals rentals){
        LOGGER.info("Update RENTALS....");
        return service.update(rentals);
    }

    @DeleteMapping("delete/{licenceNo}")
    public void deleteByLicenceNo(
            @PathVariable String licenceNo){
        service.deleteByLicenceNo(licenceNo);
    }

    @DeleteMapping("/{rentalId}")
    public void deleteById(@PathVariable int rentalId){
        service.deleteById(rentalId);
    }


}
