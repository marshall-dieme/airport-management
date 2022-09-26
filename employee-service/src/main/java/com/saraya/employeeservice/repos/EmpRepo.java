package com.saraya.employeeservice.repos;

import com.saraya.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

    List <Employee> findByServiceId(Long serviceId);
}
