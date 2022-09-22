package com.saraya.employee.services;

import java.util.List;

import com.saraya.employee.dto.EmployeeDTO;

public interface EmployeeServices {
	
	EmployeeDTO creatEmployee(EmployeeDTO dto);
	List<EmployeeDTO> getAllEmployee();
	EmployeeDTO getEmploye(Long employeeId);
	EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId);
	void deleteEmployee(Long employeeId);
}
