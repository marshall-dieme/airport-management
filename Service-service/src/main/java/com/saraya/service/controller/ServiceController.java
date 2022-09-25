package com.saraya.service.controller;

import com.saraya.service.bean.Service;
import com.saraya.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ServiceController {
    @Autowired
    private final ServiceService service;

    public ServiceController(ServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Service> getAll(){
        return service.getAll();
    }


    @PostMapping
    public Service create(@RequestBody Service service1){
        return service.create(service1);
    }


    @PutMapping("/{id}")
    public Service update(int id, @RequestBody Service service1){
        return service.update(service1);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

}
