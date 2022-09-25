package com.spring.employees.controller;


import com.spring.employees.DTO.EmployeeDto;
import com.spring.employees.bean.Employee;
import com.spring.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }


    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }
    @PostMapping("/create")
    public Employee createWithRelation(@RequestBody EmployeeDto emp) {
        return service.createWithRelation(emp);
    }
    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
       service.delete(id);
    }

}
