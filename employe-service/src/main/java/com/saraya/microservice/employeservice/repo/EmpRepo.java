package com.saraya.microservice.employeservice.repo;


import com.saraya.microservice.employeservice.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
}
