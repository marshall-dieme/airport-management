package com.saraya.service_employee.repository;

import com.saraya.service_employee.model.ServiceEmployeeRelation;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface Repository  extends JpaRepository<ServiceEmployeeRelation, Integer> {
}
