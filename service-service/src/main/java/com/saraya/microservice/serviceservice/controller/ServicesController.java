package com.saraya.microservice.serviceservice.controller;



import com.saraya.microservice.serviceservice.bean.Services;
import com.saraya.microservice.serviceservice.service.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serv")
public class ServicesController {
    private final ServicesService service ;

    public ServicesController(ServicesService service) {
        this.service = service;
    }


    @GetMapping
    public List<Services> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Services getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public Services create(@RequestBody Services arpg) {
        return service.create(arpg);
    }

    @PutMapping
    public Services update(@RequestBody Services arpg) {
        return service.update(arpg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    /*@GetMapping("/country/{country}")
    public AirportGeo getIdDept(@PathVariable String country)
    {
        return service.getIdArp(country);
    }
*/
}
