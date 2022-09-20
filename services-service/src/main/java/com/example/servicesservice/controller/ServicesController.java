package com.example.servicesservice.controller;

import com.example.servicesservice.model.Services;
import com.example.servicesservice.service.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/services")
public class ServicesController {

    private final ServicesService service;

    public ServicesController(ServicesService service) {
        this.service = service;
    }


    @GetMapping
    public List<Services> getAll(){
        return service.getAll();
    }

   /* @GetMapping("/{name}")
    public Services getByCity(String name){
        return service.getByName(name);
    }*/



    @PostMapping("/")
    public Services create(@RequestBody Services services) {

        return service.create(services);
    }

    @PutMapping("/")
    public Services update (@RequestBody Services airportGeo){
        return service.update(airportGeo);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
