package com.example.employee.controller;

import com.example.employee.bean.Employee;
import com.example.employee.repository.EmployeeRepo;
import com.example.employee.service.EmployeeService;
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
    @PutMapping
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
       service.delete(id);
    }
}
