package com.saraya.employeeservice.mapper;

import com.saraya.employeeservice.bean.Employee;
import com.saraya.employeeservice.dto.EmployeeDto;

public class EmployeeMapper {
    public Employee toEntity(EmployeeDto dto){
        Employee employee = new Employee();
        employee.setFirstname(dto.getFirstname());
        employee.setLastname(dto.getLastname());
        employee.setUsername(dto.getUsername());
        return employee;
    }
}
