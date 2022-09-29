package com.airportmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airportmanager.model.Airplane_Type;

@Repository
public interface Airplane_TypeRepository extends JpaRepository<Airplane_Type,Long> {

}
