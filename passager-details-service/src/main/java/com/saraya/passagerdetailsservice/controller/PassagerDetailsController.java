package com.saraya.passagerdetailsservice.controller;

import com.saraya.passagerdetailsservice.model.PassagerDetails;
import com.saraya.passagerdetailsservice.model.PassagerDetailsDTO;
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

    @GetMapping("/recup/{telephone}")
    public PassagerDetails getByTelephone(
            @PathVariable String telephone){
        return service.getByTelephone(telephone);
    }

    @PostMapping
    public PassagerDetails create(@RequestBody PassagerDetails passagerDetails){
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

    @GetMapping("/{telephone}")
    public Integer findByTelephone(
            @PathVariable String telephone) {
        return  service.findByTelephone(telephone).getPassagerId();
    }

}
