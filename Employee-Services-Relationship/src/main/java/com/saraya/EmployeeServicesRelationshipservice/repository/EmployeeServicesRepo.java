package com.saraya.EmployeeServicesRelationshipservice.repository;

import com.saraya.EmployeeServicesRelationshipservice.model.EmployeeServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeServicesRepo extends JpaRepository<EmployeeServices, Long> {

}
