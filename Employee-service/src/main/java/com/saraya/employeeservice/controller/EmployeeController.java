package com.saraya.employeeservice.controller;

import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.model.EmployeeDto;
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

    @GetMapping("/{username}")
    public Employee getByUsername(
            @PathVariable String username){
        return service.getByUsername(username);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDto employee){
        return service.create(employee);
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }

    @DeleteMapping("delete/{username}")
    public void deleteByUsername(
            @PathVariable String username){
        service.deleteByUsername(username);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteById(@PathVariable int employeeId){
        service.deleteById(employeeId);
    }

}
