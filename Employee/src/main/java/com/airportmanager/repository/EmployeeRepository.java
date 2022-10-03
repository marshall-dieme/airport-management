package com.airportmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airportmanager.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
