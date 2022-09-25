package com.saraya.Employeeservice.controller;

import com.saraya.Employeeservice.dto.EmployeeDto;
import com.saraya.Employeeservice.model.Employee;
import com.saraya.Employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("employees")
public class EmployeeRestController {

    private final EmployeeService service;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long employee_id) {
        return ResponseEntity.ok(service.getEmployee(employee_id));
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<>(service.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/{employee_id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employee_id) {
        service.deleteEmployee(employee_id);
        return ResponseEntity.ok("Employee "+employee_id+" has been deleted");
    }

    @GetMapping("/employee-email/{email}")
    public ResponseEntity<EmployeeDto> getEmployeeByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getEmployeeByEmail(email));
    }
}
