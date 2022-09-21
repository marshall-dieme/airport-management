package com.saraya.employeeservice.service;

import com.saraya.employeeservice.dto.EmployeeDto;
import com.saraya.employeeservice.model.Employee;
import com.saraya.employeeservice.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    public EmployeeDto getEmpNo(String empNo){
        return mapper.map(repo.findById(empNo).orElse(new Employee()), EmployeeDto.class)
    }


    public EmployeeDto update (EmployeeDto dto)
    {
        Employee emp = mapper.map(dto, Employee.class);
        return mapper.map(repo.save(emp), EmployeeDto.class)
    }

    public void delete(String empNo){
        repo.deleteById(empNo);
    }

    public void currentAdvantageRate(LocalDate spentYears){

    }


}
