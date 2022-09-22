package com.saraya.employeeservice.controller;

import com.saraya.employeeservice.bean.Employee;
import com.saraya.employeeservice.bean.EmployeeDto;
import com.saraya.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDto dto){
        return service.create(dto);
    }
}
