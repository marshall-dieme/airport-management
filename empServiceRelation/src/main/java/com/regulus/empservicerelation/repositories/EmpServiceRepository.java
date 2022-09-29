package com.regulus.empservicerelation.repositories;

import com.regulus.empservicerelation.models.EmpServiceRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpServiceRepository extends JpaRepository<EmpServiceRelation, Integer> {
}
