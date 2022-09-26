package com.saraya.employeesServicesservice.controller;

import com.saraya.employeesServicesservice.model.EmployeeServices;
import com.saraya.employeesServicesservice.repos.EMpSerRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empserv")
public class EmpSerController {
    private final EMpSerRepo repo;

    public EmpSerController(EMpSerRepo repo) {
        this.repo = repo;
    }


    @GetMapping("/{serviceId}/{employeeId}")
    public void create(@PathVariable Long serviceId,
                       @PathVariable Long employeeId) {
        EmployeeServices empser = new EmployeeServices();
        empser.setEmployeeId(employeeId);
       empser.setServiceId(serviceId);
        repo.save(empser);
    }
}
