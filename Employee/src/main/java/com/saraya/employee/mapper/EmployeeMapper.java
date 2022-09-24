package com.saraya.employee.mapper;

import com.saraya.employee.dto.EmployeeDto;
import com.saraya.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeMapper implements EntityMapper<EmployeeDto, Employee>{
    @Override
    public Employee toEntity(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setEmployee_id(dto.getEmployee_id());
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        employee.setBirthdate(dto.getBirthdate());
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
        employee.setService_id(dto.getService_id());
        return employee;
    }

    @Override
    public EmployeeDto toDto(Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmployee_id(entity.getEmployee_id());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setBirthdate(entity.getBirthdate());
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
        dto.setService_id(entity.getService_id());
        return dto;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDto> dtoList) {
        List<Employee> employees = new ArrayList<>();
        for (EmployeeDto dto : dtoList){
            Employee employee = toEntity((dto));
            employees.add(employee);
        }
        return employees;
    }
    @Override
    public List<EmployeeDto> toDto(List<Employee> entityList) {
        List<EmployeeDto> dtoList = new ArrayList<>();
        for (Employee employee : entityList){
            EmployeeDto dto = toDto(employee);
            dtoList.add(dto);

        }
        return dtoList;
    }
}
