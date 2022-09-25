package com.saraya.employeeservice.repo;

import com.saraya.employeeservice.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String username);
}
