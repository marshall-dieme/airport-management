package com.saraya.microservice.serviceservice.repo;


import com.saraya.microservice.serviceservice.bean.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Services, Integer> {
}
