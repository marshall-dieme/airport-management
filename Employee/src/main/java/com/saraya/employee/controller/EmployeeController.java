package com.saraya.employee.controller;

import com.saraya.employee.dto.EmployeeDto;
import com.saraya.employee.model.Employee;
import com.saraya.employee.service.EmployeeService;
import com.saraya.employee.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    @Autowired
    private EmployeeService service;


    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<> (service.save(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/{employee_id}")
    public ResponseTemplateVo getEmployeeWithService(@PathVariable long employee_id){
        return service.getEmployeeWithService(employee_id);
    }

    @PutMapping("/")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok(service.update(employeeDto));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> delete(@PathVariable long id){
        service.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.ACCEPTED);
    } 

}
