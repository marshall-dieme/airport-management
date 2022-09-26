package com.saraya.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.saraya.employee.model.EmployeeDTO;

@Service
public interface EmployeeService {
	
	List<EmployeeDTO> getAll();
	
	EmployeeDTO getById(Long id);
	
	EmployeeDTO create(EmployeeDTO employeeDTO);
	
	EmployeeDTO update(EmployeeDTO employeeDTO, Long id);
	
	void delete(Long id);
}
