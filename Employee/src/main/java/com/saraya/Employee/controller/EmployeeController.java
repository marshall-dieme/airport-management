package com.saraya.Employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saraya.Employee.model.Employee;
import com.saraya.Employee.model.EmployeeDto;
import com.saraya.Employee.service.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private final EmployeeService service ;

    public  EmployeeController (EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/{firstname}")
    public Employee getByFirstname(@PathVariable String firstname){
        return service.getByFirstname(firstname);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeDto employeeDto){
        return service.create(employeeDto);
    }
   

    @PutMapping
    public Employee update(@RequestBody EmployeeDto employeeDto){
        return service.update(employeeDto);
    }

    @DeleteMapping("delete/{firstname}")
    public void deleteByFirstname(@PathVariable String firstname){
        service.getByFirstname(firstname);
    }



}
