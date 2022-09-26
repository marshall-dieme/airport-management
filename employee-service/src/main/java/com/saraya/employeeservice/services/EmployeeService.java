package com.saraya.employeeservice.services;

import com.saraya.employeeservice.exceptions.ResourceNotFoundException;
import com.saraya.employeeservice.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface EmployeeService {

    Employee add(Employee employee);
    Employee update(Employee employee);
    Employee getEmployee(Long employee_id) throws ResourceNotFoundException;
    Page<Employee> getEmployees(Pageable pageable);
    void delete(Long employee_id) throws ResourceNotFoundException;
    boolean existEmployee(Long employee_id);

}
