package com.spring.airlinesservices.repository;


import com.spring.airlinesservices.bean.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirlineRepo extends JpaRepository<Airline,Integer> {
}
