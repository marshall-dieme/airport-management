package com.microservices.employeeserviceairport.controller;


import com.microservices.employeeserviceairport.entity.EmployeeDTO;
import com.microservices.employeeserviceairport.entity.Employee;
import com.microservices.employeeserviceairport.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id_employee}")
    public Optional<Employee> getById(@PathVariable Long id_employee) {
        return service.getById(id_employee);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDTO employee) {
        return service.create(employee);
    }

    @PutMapping
    public Employee update(@RequestBody EmployeeDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id_employee}")
    public void delete(@PathVariable Long id_employee) {
        service.delete(id_employee);
    }

    @PostMapping("/create")
    public Employee CreateWithRelation(@RequestBody EmployeeDTO employee) {
        return service.CreateWithRelation(employee);
    }
    @GetMapping("/{servicesName}/employees")
    public List<Employee> getEmpByServ(@PathVariable String servicesName) {
        return service.getByServ(servicesName);
    }
}
