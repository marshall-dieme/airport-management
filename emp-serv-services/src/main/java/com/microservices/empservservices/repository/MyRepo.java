package com.microservices.empservservices.repository;


import com.microservices.empservservices.entity.EmpServRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepo extends JpaRepository<EmpServRelation, Integer> {


}
