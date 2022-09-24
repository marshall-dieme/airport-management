package com.microservices.serviceairportservices.repository;

import com.microservices.serviceairportservices.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ServiceRepo extends JpaRepository<Services, Long> {
    @Override
    Optional<Services> findById(Long servicesId);

    List <Services> findByIdAirport(String idAirport);


    @Query("select s.servId from Services s where s.servicesName =:servicesName")
    String getIdServ(String servicesName);

    Services findByName(String servicesName);
}
