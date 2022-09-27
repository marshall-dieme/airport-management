package com.saraya.Employeeservice.mapper;

import com.saraya.Employeeservice.dto.EmployeeDto;
import com.saraya.Employeeservice.enums.Gender;
import com.saraya.Employeeservice.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public Employee mapToEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setEmployee_id(dto.getEmployee_id());
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        employee.setBirthdate(LocalDate.parse(dto.getBirthdate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        employee.setCity(dto.getCity());
        employee.setCountry(dto.getCountry());
        employee.setEmail(dto.getEmail());
        employee.setSex(Gender.valueOf(dto.getSex()));
        employee.setStreet(dto.getStreet());
        employee.setTelephone(dto.getTelephone());
        employee.setZip(dto.getZip());
        employee.setUsername(dto.getUsername());
        employee.setPassword(dto.getPassword());
        return employee;
    }

    public EmployeeDto mapToDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployee_id(employee.getEmployee_id());
        dto.setFirstname(employee.getFirstname());
        dto.setLastname(employee.getLastname());
        dto.setBirthdate(employee.getBirthdate().toString());
        dto.setCity(employee.getCity());
        dto.setCountry(employee.getCountry());
        dto.setEmail(employee.getEmail());
        dto.setSex(employee.getSex().toString());
        dto.setStreet(employee.getStreet());
        dto.setTelephone(employee.getTelephone());
        dto.setZip(employee.getZip());
        dto.setUsername(employee.getUsername());
        dto.setPassword(employee.getPassword());
        return dto;
    }
}
