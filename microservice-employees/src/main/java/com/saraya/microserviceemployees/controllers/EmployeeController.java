package com.saraya.microserviceemployees.controllers;

import com.saraya.microserviceemployees.dto.EmployeeDto;
import com.saraya.microserviceemployees.exceptions.ResourceNotFoundException;
import com.saraya.microserviceemployees.mappers.EmployeeMapper;
import com.saraya.microserviceemployees.models.Employee;
import com.saraya.microserviceemployees.services.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody EmployeeDto employeeDto){

        Employee employee = employeeService.add(employeeMapper.employeeDtoToEmployee(employeeDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeMapper.employeeToEmployeeDto(employee));
    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        List<Employee> employeeList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC);
        Page<Employee> employeePage = this.employeeService.getEmployees(pageable);
        employeeList = employeePage.getContent();
        Map<String,Object>  response = new HashMap<>();
        response.put("employees",this.employeeMapper.employeesToEmployeeDtos(employeeList));
        response.put("currentPage",employeePage.getNumber());
        response.put("totalItems",employeePage.getTotalElements());
        response.put("totalPages",employeePage.getTotalPages());

        if (employeeList.isEmpty())
            return new ResponseEntity<Map<String, Object>>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        Employee employee = this.employeeService.getEmployee(id);

        return new ResponseEntity<EmployeeDto>(this.employeeMapper.employeeToEmployeeDto(employee),HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Long id) throws ResourceNotFoundException {
        if (id==null || id<1)
            return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
         this.employeeService.delete(id);
         return ResponseEntity.noContent().build();
    }
}
