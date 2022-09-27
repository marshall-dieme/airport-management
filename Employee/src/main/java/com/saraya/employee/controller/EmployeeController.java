package com.saraya.employee.controller;

import com.saraya.employee.dto.EmployeeDto;
import com.saraya.employee.model.Employee;
import com.saraya.employee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService service;


    @PostMapping
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        return service.save(employeeDto);
    }
    @GetMapping
    public List<Employee> getAll(){
        return service.findAll();
    }

    @PostMapping("/EmployeeService")
    public EmployeeDto saveEmpServRelation(@RequestBody EmployeeDto employeeDto){
        return service.createServEmpWithRelation(employeeDto);
    }


    @GetMapping("/{employee_id}")
    public EmployeeDto getEmployee(@PathVariable long employee_id){
        return service.getEmployeeById(employee_id);
    }

    @PutMapping("/{employee_id}")
    public EmployeeDto update(@RequestBody EmployeeDto employeeDto, @PathVariable("employee_id") long employee_id){
        return service.update(employeeDto,employee_id );
    }

    @DeleteMapping("/{id}")
    public  void  delete(@PathVariable long id){
        service.deleteById(id);
    } 

}
