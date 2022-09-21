package com.saraya.servicesservice.controller;

import com.saraya.servicesservice.model.Services;
import com.saraya.servicesservice.model.ServicesDto;
import com.saraya.servicesservice.service.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Services create(@RequestBody ServicesDto dto) {

        return service.create(dto);
    }

    @PutMapping("/")
    public Services update (@RequestBody ServicesDto dto){
        return service.update(dto);
    }



    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.delete(id);
    }
}
