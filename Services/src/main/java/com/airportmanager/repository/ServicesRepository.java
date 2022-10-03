package com.airportmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airportmanager.model.Services;

@Repository
public interface ServicesRepository  extends JpaRepository<Services,Long> {

}
