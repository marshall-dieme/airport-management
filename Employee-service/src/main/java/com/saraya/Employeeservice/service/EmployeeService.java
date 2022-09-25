package com.saraya.Employeeservice.service;

import com.saraya.Employeeservice.dto.EmployeeDto;
import com.saraya.Employeeservice.mapper.Mapper;
import com.saraya.Employeeservice.model.Employee;
import com.saraya.Employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    private final Mapper mapper;

    public List<EmployeeDto> getAllEmployees() {
        return repository.findAll().stream().map(mapper::mapToDto).toList();
    }

    public EmployeeDto getEmployee(Long employee_id) {
        Employee employee = repository.findById(employee_id).orElse(null);
        return employee != null ? mapper.mapToDto(employee) : null;
    }

    public Employee saveEmployee(EmployeeDto dto) {
        Employee employee = repository.save(mapper.mapToEntity(dto));
        System.out.println(employee);
        return employee;
    }

    public Employee updateEmployee(EmployeeDto dto) {
        return repository.save(mapper.mapToEntity(dto));
    }

    public void deleteEmployee(Long employee_id){
        repository.deleteById(employee_id);
    }


    public EmployeeDto getEmployeeByEmail(String email) {
        return mapper.mapToDto(repository.findEmployeeByEmail(email));
    }



}
