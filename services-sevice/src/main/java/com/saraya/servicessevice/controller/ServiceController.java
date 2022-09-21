package com.saraya.servicessevice.controller;

import com.saraya.servicessevice.bean.ServiceDto;
import com.saraya.servicessevice.bean.Services;
import com.saraya.servicessevice.service.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Services")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Services> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Services create(@RequestBody ServiceDto dto){
       return service.creat(dto);
    }

    @GetMapping("/{name}")
    public int idServices(@PathVariable("name") String name){
        return service.getIdServiceByName(name);
    }
}
