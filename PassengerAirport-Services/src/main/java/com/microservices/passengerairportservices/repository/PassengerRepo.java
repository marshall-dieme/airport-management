package com.microservices.passengerairportservices.repository;


import com.microservices.passengerairportservices.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Long> {

    @Override
    Optional<Passenger> findById(Long idPassenger);

    @Query("select p.passengerId from Passenger p where p.NumberPassport=:NumberPassport")
    String getById(String NumberPassport);

}
