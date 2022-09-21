package com.saraya.employeeservice.controller;

import com.saraya.employeeservice.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @GetMapping("/{empNo}")
    public EmployeeDto getByName(@PathVariable String empNo){
        EmployeeDto dto = service.getByEmpNo(empNo);
        getRestTemplateDetails(dto);
        return dto;

    }

    @PostMapping("/")
    public EmployeeDto create(@RequestBody EmployeeDto emp){
        EmployeeDto employeeDto= service.create(emp);
        getRestTemplateDetails(employeeDto);
        return employeeDto;
    }
}
