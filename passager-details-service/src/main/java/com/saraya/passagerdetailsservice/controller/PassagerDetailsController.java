package com.saraya.passagerdetailsservice.controller;

import com.saraya.passagerdetailsservice.model.PassagerDTO;
import com.saraya.passagerdetailsservice.model.PassagerDetails;
import com.saraya.passagerdetailsservice.service.PassagerDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passagers-details")
public class PassagerDetailsController {

    private final Logger LOGGER = LoggerFactory.getLogger(PassagerDetailsController.class);

    private final PassagerDetailsService service;

    public PassagerDetailsController(PassagerDetailsService service) {
        this.service = service;
    }

    @GetMapping
    public List<PassagerDetails> getAll(){
        LOGGER.info("List of Passager Details...");
        return service.getAll();
    }

    @GetMapping("/recup/{email}")
    public PassagerDetails getByEmail(
            @PathVariable String email){
        return service.getByEmail(email);
    }

    @PostMapping
    public PassagerDTO create(@RequestBody PassagerDTO passagerDetails){
        LOGGER.info("CREATING NEW Passagers Details...");
        return service.create(passagerDetails);
    }

    @PutMapping
    public PassagerDetails update(@RequestBody PassagerDetails passagerDetails){
        LOGGER.info("Update Passagers Details....");
        return service.update(passagerDetails);
    }

    @DeleteMapping("delete/{telephone}")
    public void deleteByTelephone(
            @PathVariable String telephone){
        service.deleteByTelephone(telephone);
    }

    @DeleteMapping("/{passagerDetailsId}")
    public void deleteById(@PathVariable int passagerDetailsId){
        service.deleteById(passagerDetailsId);
    }

    @GetMapping("/{email}")
    public PassagerDetails findByEmail(
            @PathVariable String email) {
        return  service.findByEmail(email);
    }

}
