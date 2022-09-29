package com.regulus.employeeservice.services;


import com.regulus.employeeservice.dtos.EmployeeDto;
import com.regulus.employeeservice.models.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Mapper {

    public EmployeeDto toDto(Employee employee){
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployee_id(employee.getEmployee_id());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dto.setBirthDate(employee.getBirthDate().format(formatter));
        dto.setSex(employee.getSex());
        dto.setStreet(employee.getStreet());
        dto.setCity(employee.getCity());
        dto.setZip(employee.getZip());
        dto.setCountry(employee.getCountry());
        dto.setEmail(employee.getEmail());
        dto.setTelephone(employee.getTelephone());
        dto.setSalary(employee.getSalary());
        dto.setUserName(employee.getUserName());
        dto.setPassword(employee.getPassword());
        return dto;
    }

    public Employee toEntity(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setEmployee_id(dto.getEmployee_id());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        employee.setBirthDate(LocalDate.parse(dto.getBirthDate(),formatter));
        employee.setSex(dto.getSex());
        employee.setStreet(dto.getStreet());
        employee.setCity(dto.getCity());
        employee.setZip(dto.getZip());
        employee.setCountry(dto.getCountry());
        employee.setEmail(dto.getEmail());
        employee.setTelephone(dto.getTelephone());
        employee.setSalary(dto.getSalary());
        employee.setUserName(dto.getUserName());
        employee.setPassword(dto.getPassword());
        return employee;
    }
}
