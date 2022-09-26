package com.saraya.employeesServicesservice.repos;

import com.saraya.employeesServicesservice.model.EmployeeServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EMpSerRepo extends JpaRepository<EmployeeServices,Long> {
}
