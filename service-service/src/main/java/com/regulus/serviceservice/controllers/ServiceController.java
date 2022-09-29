package com.regulus.serviceservice.controllers;

import com.regulus.serviceservice.dtos.ServiceDto;
import com.regulus.serviceservice.models.Service;
import com.regulus.serviceservice.services.ServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getServiceList(){
        return serviceService.getService();
    }

    @PostMapping
    public ServiceDto create(@RequestBody ServiceDto serviceDto){
        return serviceService.createService(serviceDto);
    }

    @PutMapping("/{id}")
    public ServiceDto update(@PathVariable("id") int id, @RequestBody ServiceDto serviceDto){
        return serviceService.updateService(serviceDto, id);
    }

    @GetMapping("/{id}")
    public ServiceDto getService(@PathVariable("id") int id ){
        return serviceService.getService(id);
    }

    @GetMapping("/name/{name}")
    public Integer getServiceIDByName(@PathVariable("name") String name){
        return serviceService.getServiceID(name);
    }


    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable("id") int id){
        serviceService.deleteService(id);
    }


}
