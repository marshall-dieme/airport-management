package com.saraya.employeeservicesservice.controller;

import com.saraya.employeeservicesservice.bean.EmployeeService;
import com.saraya.employeeservicesservice.service.EmployeeServiceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Relation")
public class EmployeeServiceController {

    private final EmployeeServiceService service;

    public EmployeeServiceController(EmployeeServiceService service) {
        this.service = service;
    }

    @GetMapping("/{empId}/{servId}")
    public void create(@PathVariable("empId") int empId, @PathVariable("servId") int servId){
        EmployeeService employeeService = new EmployeeService();
        employeeService.setEmployeeId(empId);
        employeeService.setServiceId(servId);
        service.create(employeeService);
    }

    @GetMapping
    public List<EmployeeService> getAll(){
        return service.getAll();
    }

    @GetMapping("/serviceId")
    public List<Integer> getServiceId(){
        return service.getServiceId();
    }

    @GetMapping("/employeeId")
    public List<Integer> getEmployeeId(){
        return service.getEmployeeId();
    }
}
