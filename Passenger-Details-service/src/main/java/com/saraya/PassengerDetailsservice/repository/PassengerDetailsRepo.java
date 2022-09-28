package com.saraya.PassengerDetailsservice.repository;

import com.saraya.PassengerDetailsservice.model.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails, Long> {
    @Query("select p from PassengerDetails p where p.passenger_details_id = ?1")
    PassengerDetails findPassengerByPassenger_details_id(Long passenger_details_id);

}
