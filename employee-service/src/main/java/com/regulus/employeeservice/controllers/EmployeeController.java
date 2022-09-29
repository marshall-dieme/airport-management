package com.regulus.employeeservice.controllers;

import com.regulus.employeeservice.dtos.EmployeeDto;
import com.regulus.employeeservice.models.Employee;
import com.regulus.employeeservice.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService serviceEmployee;

    public EmployeeController(EmployeeService serviceEmployee) {
        this.serviceEmployee = serviceEmployee;
    }

    @GetMapping
    public List<Employee> getEmployeeList(){
        return serviceEmployee.getEmployee();
    }

    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto){
        return serviceEmployee.createEmployee(employeeDto);
    }

    @PostMapping("/createRelation")
    public EmployeeDto createWithRelation(@RequestBody EmployeeDto emp) {
        return serviceEmployee.createWithRelation(emp);
    }

    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto){
        return serviceEmployee.updateEmployee(employeeDto, id);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable("id") int id ){
        return serviceEmployee.getEmployee(id);
    }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id){
        serviceEmployee.deleteEmployee(id);
    }


}
