package com.saraya.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.saraya.Employee.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

	Employee findByFirstname(String firstname);

}
