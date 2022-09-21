package com.microservices.serviceairportservices.repository;

import com.microservices.serviceairportservices.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service, String> {

    @Query("select s.servicesId from Service s where s.servicesName=:servicesName")

    String getidServices(String servicesName);
}
