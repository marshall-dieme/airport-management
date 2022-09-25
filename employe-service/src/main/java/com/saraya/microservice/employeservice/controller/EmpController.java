package com.saraya.microservice.employeservice.controller;

import com.saraya.microservice.employeservice.bean.Employee;
import com.saraya.microservice.employeservice.bean.EmployeeDTo;
import com.saraya.microservice.employeservice.service.EmployeService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmpController {

    private final EmployeService service;

    public EmpController(EmployeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDTo emp) {
        return service.create(emp);
    }

    @PutMapping
    public Employee update(@RequestBody EmployeeDTo dto) {
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
