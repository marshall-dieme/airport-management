package com.microservices.employeeserviceairport.repository;


import com.microservices.employeeserviceairport.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {


}
