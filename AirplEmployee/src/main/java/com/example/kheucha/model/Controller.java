package com.example.kheucha.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kheucha.dao.Dao;
import com.example.kheucha.entities.Employee;
import com.example.kheucha.exception.ResourceNotFoundException;



 @RestController
@RequestMapping(value="/api/vv")
public class Controller {
	@Autowired
    private Dao chico;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return chico.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeid)
        throws ResourceNotFoundException {
        Employee employee = chico.findById(employeeid)
          .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeid));
        return ResponseEntity.ok().body(employee);
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@Validated @RequestBody Employee employee) {
        return chico.save(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
    		@Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = chico.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
         
        employee.setLastname(employeeDetails.getLastname());
        employee.setFirstname(employeeDetails.getFirstname());
        
//        employee.setBirthdate(employeeDetails.getBirthdate());
        employee.setSex(employeeDetails.getSex());
        employee.setStreet(employeeDetails.getStreet());
       
        employee.setCity(employeeDetails.getCity());
        employee.setZip(employeeDetails.getZip());
        employee.setCountry(employeeDetails.getCountry());
        employee.setEmail(employeeDetails.getEmail());

        
        employee.setTelephone(employeeDetails.getTelephone());
        employee.setSalary(employeeDetails.getSalary());
        employee.setUsername(employeeDetails.getUsername());
        employee.setPassword(employeeDetails.getPassword());

        
        final Employee updatedEmployee = chico.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
         throws ResourceNotFoundException {
        Employee employee = chico.findById(employeeId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        chico.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

