package com.saraya.employeeservice.controller;

import com.saraya.employeeservice.dto.ResponseTemplateDto;
import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.dto.EmployeeDTO;
import com.saraya.employeeservice.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {
    private EmployeeService service;


    @GetMapping
    public List<Employee> getAll(){
        return service.getAll();
    }

    @GetMapping("/emp_id")
    public Optional <Employee> getById(@PathVariable Long emp_id){
        return service.getById(emp_id);

    }
    @PostMapping
    public Employee create(@RequestBody EmployeeDTO dto){
        return service.create(dto);
    }
//    @PostMapping("/create")
//    public Employee createWithRelation(@RequestBody  EmployeeDTO dto){
//        return service.createWithRelation(dto);
//    }
    @PutMapping
    public Employee update(Employee employee){
        return service.update(employee);
    }

    @DeleteMapping("/emp_id")
    public void deleteById(@PathVariable Long emp_id){
        service.delete(emp_id);
    }

    @GetMapping("/emp_id")
    public ResponseTemplateDto getEmployeeWithService(@PathVariable Long emp_id){
        return service.getEmployeeWithService(emp_id);
    }
}
