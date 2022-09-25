package com.saraya.passenger_details.repository;

import com.saraya.passenger_details.model.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Passenger_DetailsRepo extends JpaRepository<PassengerDetails, Long> {

}
