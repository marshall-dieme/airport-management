package com.saraya.servicesservice.controller;

import com.saraya.servicesservice.model.Service;
import com.saraya.servicesservice.model.ServiceDto;
import com.saraya.servicesservice.service.ServiceServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServicesController {
    private final ServiceServices service;

    public ServicesController(ServiceServices service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Service> getAll(){
        return service.getAll();
    }


    @GetMapping("/serviceName/{serviceName}")
    public Long getIdService(@PathVariable String serviceName){
        return service.getIdService(serviceName);
    }

    @GetMapping("/{airportName}/airport")
    public List <Service>  getServiceByAirport(@PathVariable String airportName) {
        return service.getServiceByAirport(airportName);
    }


    @PostMapping("/")
    public Service create(@RequestBody ServiceDto dto) {

        return service.create(dto);
    }

    @PutMapping("/")
    public Service update (@RequestBody ServiceDto dto){
        return service.update(dto);
    }



    @DeleteMapping("/{service_id}")
    public void deleteById(@PathVariable Long service_id){
        service.deleteById(service_id);
    }

}
