package com.saraya.employee.mapper;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.saraya.employee.dto.EmployeeDTO;
import com.saraya.employee.model.Employee;

@Component
public class ConvertEmployee {
	public Employee toEmployee(EmployeeDTO dto) {
		Employee employee = new Employee();
		employee.setBirthdate(LocalDate.parse(dto.getBirthdate()));
		employee.setCity(dto.getCity());
		employee.setCountry(dto.getCountry());
		employee.setEmail(dto.getEmail());
		employee.setFirstname(dto.getFirstname());
		employee.setLastname(dto.getLastname());
		employee.setPassword(dto.getPassword());
		employee.setSalary(dto.getSalary());
		employee.setSex(dto.getSex());
		employee.setStreet(dto.getStreet());
		employee.setTelephone(dto.getTelephone());
		employee.setUsername(dto.getUsername());
		employee.setZip(dto.getZip());
		return employee;
	}
	
	public EmployeeDTO todto(Employee employee) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(employee.getEmployee_id());
		dto.setBirthdate(employee.getBirthdate().toString());
		dto.setCity(employee.getCity());
		dto.setCountry(employee.getCountry());
		dto.setEmail(employee.getEmail());
		dto.setFirstname(employee.getFirstname());
		dto.setLastname(employee.getLastname());
		dto.setPassword(employee.getPassword());
		dto.setSalary(employee.getSalary());
		dto.setSex(employee.getSex());
		dto.setStreet(employee.getStreet());
		dto.setTelephone(employee.getTelephone());
		dto.setUsername(employee.getUsername());
		dto.setZip(employee.getZip());
		return dto;
	}
}
