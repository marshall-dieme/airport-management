package com.saraya.employee.mapper;

import com.saraya.employee.dto.EmployeeDto;
import com.saraya.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class EmployeeMapper {

    public Employee toEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setEmployee_id(dto.getEmployee_id());
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        employee.setBirthdate(LocalDate.parse(employee.getBirthdate().format(formatter)));
        employee.setSex(dto.getSex());
        employee.setStreet(dto.getStreet());
        employee.setCity(dto.getCity());
        employee.setZip(dto.getZip());
        employee.setCountry(dto.getCountry());
        employee.setEmail(dto.getEmail());
        employee.setTelephone(dto.getTelephone());
        employee.setSalary(dto.getSalary());
        employee.setUsername(dto.getUsername());
        employee.setPassword(dto.getPassword());

        return employee;
    }

    public EmployeeDto toDto(Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployee_id(entity.getEmployee_id());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dto.setBirthdate(LocalDate.parse(dto.getBirthdate().format(formatter)));
        dto.setSex(entity.getSex());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setZip(entity.getZip());
        dto.setCountry(entity.getCountry());
        dto.setEmail(entity.getEmail());
        dto.setTelephone(entity.getTelephone());
        dto.setSalary(entity.getSalary());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

}
