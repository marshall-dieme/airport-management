package com.saraya.Employeeservice.service;

import com.saraya.Employeeservice.model.Employee;
import com.saraya.Employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(Long employee_id) {
        return repository.findById(employee_id).orElse(new Employee());
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long employee_id){
        repository.deleteById(employee_id);
    }

}
