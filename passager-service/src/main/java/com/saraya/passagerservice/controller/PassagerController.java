package com.saraya.passagerservice.controller;

import com.saraya.passagerservice.model.Passager;
import com.saraya.passagerservice.model.PassagerDTO;
import com.saraya.passagerservice.service.PassagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passager")
public class PassagerController {

    private final Logger LOGGER = LoggerFactory.getLogger(PassagerController.class);

    private final PassagerService service;

    public PassagerController(PassagerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Passager> getAll(){
        return service.getAll();
    }

    @GetMapping("/recup/{firstName}/{lastName}")
    public Passager getByFirstNameAndLastName(
            @PathVariable String firstName , @PathVariable String lastName){
        return service.getByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping
    public PassagerDTO create(@RequestBody PassagerDTO passager){
        LOGGER.info("CREATING a NEW PASSAGER...");
        return service.create(passager);
    }

    @PutMapping
    public Passager update(@RequestBody Passager passager){
        LOGGER.info("Update A PASSAGER....");
        return service.update(passager);
    }

    @DeleteMapping("delete/{firstName}/{lastName}")
    public void deleteByFirstNameAndLastName(
            @PathVariable String firstName , @PathVariable String lastName){
        service.deleteByFirstNameAndLastName(firstName, lastName);
    }

    @DeleteMapping("/{passagerId}")
    public void deleteById(@PathVariable int passagerId){
        service.deleteById(passagerId);
    }

}
