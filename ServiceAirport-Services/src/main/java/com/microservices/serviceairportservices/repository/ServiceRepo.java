package com.microservices.serviceairportservices.repository;

import com.microservices.serviceairportservices.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ServiceRepo extends JpaRepository<Services, Long> {
    @Override
    Optional<Services> findById(Long servicesId);


    Services findByIdAirport(String idAirport);

}
