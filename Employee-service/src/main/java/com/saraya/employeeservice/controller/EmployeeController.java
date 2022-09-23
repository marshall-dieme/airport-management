package com.saraya.employeeservice.controller;

import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{firstName}")
    public Employee getByFirstName(
            @PathVariable String firstName){
        return service.getByFirstName(firstName);
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }

    @DeleteMapping("delete/{firstName}")
    public void deleteByFirstName(
            @PathVariable String firstName){
        service.deleteByFirstName(firstName);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteById(@PathVariable int employeeId){
        service.deleteById(employeeId);
    }

}
