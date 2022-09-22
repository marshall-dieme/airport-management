package com.saraya.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.services.model.ServiceEntity;
@Repository
public interface serviceRepo extends JpaRepository<ServiceEntity, Long>{

}
