package com.microservices.employeeserviceairport.repository;


import com.microservices.employeeserviceairport.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    List<Employee> findByIdServ(String idServ);


}
