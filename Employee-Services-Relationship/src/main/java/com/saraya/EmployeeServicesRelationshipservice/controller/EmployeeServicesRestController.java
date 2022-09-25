package com.saraya.EmployeeServicesRelationshipservice.controller;

import com.saraya.EmployeeServicesRelationshipservice.dto.EmployeeServicesDto;
import com.saraya.EmployeeServicesRelationshipservice.model.EmployeeServices;
import com.saraya.EmployeeServicesRelationshipservice.service.EmployeeServicesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("relation")
@RestController
public class EmployeeServicesRestController {

    private final EmployeeServicesService service;


    @PostMapping
    public void createEmployeeServices(@RequestBody EmployeeServicesDto services) {
        service.createEmpIdAndServiceId(services);
    }
}
