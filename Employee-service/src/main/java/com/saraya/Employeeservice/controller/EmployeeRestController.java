package com.saraya.Employeeservice.controller;

import com.saraya.Employeeservice.model.Employee;
import com.saraya.Employeeservice.repository.EmployeeRepository;
import com.saraya.Employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    private final EmployeeService service;

    private final EmployeeRepository repository;

    @GetMapping("/allEmployees")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/find/{employee_id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employee_id) {
        return ResponseEntity.ok(service.getEmployee(employee_id));
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{employee_id}")
    public ResponseEntity<Employee> updateEmployee( @PathVariable Long employee_id, @RequestBody Employee employee) {

        Employee newEmployee = repository.findById(employee_id).orElse(new Employee());

        newEmployee.setFirstname(newEmployee.getFirstname());
        newEmployee.setLastname(newEmployee.getLastname());
        newEmployee.setBirthdate(newEmployee.getBirthdate());
        newEmployee.setFemale(newEmployee.getFemale());
        newEmployee.setMale(newEmployee.getMale());
        newEmployee.setEmail(newEmployee.getEmail());
        newEmployee.setTelephone(newEmployee.getTelephone());
        newEmployee.setSalary(newEmployee.getSalary());
        newEmployee.setStreet(newEmployee.getStreet());
        newEmployee.setCity(newEmployee.getCity());
        newEmployee.setCountry(newEmployee.getCountry());
        newEmployee.setZip(newEmployee.getZip());
        newEmployee.setUsername(newEmployee.getUsername());
        newEmployee.setPassword(newEmployee.getPassword());


        return new ResponseEntity<>(service.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{employee_id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employee_id) {
        return ResponseEntity.ok("Employee "+employee_id+" has already deleted");
    }
}
