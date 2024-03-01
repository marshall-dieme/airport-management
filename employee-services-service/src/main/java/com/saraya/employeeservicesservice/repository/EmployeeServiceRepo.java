package com.saraya.employeeservicesservice.repository;

import com.saraya.employeeservicesservice.bean.EmployeeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeServiceRepo extends JpaRepository<EmployeeService, Integer> {
}
