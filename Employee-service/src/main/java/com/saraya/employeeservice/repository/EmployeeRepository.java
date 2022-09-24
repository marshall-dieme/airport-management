package com.saraya.employeeservice.repository;

import com.saraya.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer> {


	Employee findByUsername(String username);
}
