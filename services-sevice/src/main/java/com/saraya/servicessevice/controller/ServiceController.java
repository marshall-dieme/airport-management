package com.saraya.servicessevice.controller;

import com.saraya.servicessevice.dto.ServiceDto;
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

    @PostMapping("airport/{serviceId}/{airportName}")
    public Services putAirpotIdForService(@PathVariable("serviceId") int serviceId,
                                          @PathVariable("airportName") String airportName){
        return service.putAirportForService(serviceId, airportName);
    }

    @PostMapping("employee/{serviceId}/{employeeUsername}")
    public String putEmployeeForService(@PathVariable("serviceId") int serviceId,
                                          @PathVariable("employeeUsername") String employeeUsername){
       return service.putEmployeeForService(serviceId, employeeUsername);
    }

    @GetMapping("/{name}")
    public int idServices(@PathVariable("name") String name){
        System.out.println(service.getIdServiceByName(name));
        return service.getIdServiceByName(name);
    }

    @GetMapping("/listEmployee")
    public List<Integer> getEmployeeId(){
        return service.getListEmployee();
    }
}
