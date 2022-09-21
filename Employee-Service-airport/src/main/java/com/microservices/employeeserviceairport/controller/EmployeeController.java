package com.microservices.employeeserviceairport.controller;


import com.microservices.employeeserviceairport.dto.EmployeeDTO;
import com.microservices.employeeserviceairport.entity.Employee;
import com.microservices.employeeserviceairport.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable Long id_employee) {
        return service.getById(id_employee);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDTO emp) {
        return service.create(emp);
    }

    @PutMapping
    public Employee update(@RequestBody EmployeeDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id_employee) {
        service.delete(id_employee);
    }
}
