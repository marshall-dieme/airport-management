package com.saraya.passengerdetais.repo;

import com.saraya.passengerdetais.model.PassengerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerDetailsRepo extends JpaRepository<PassengerDetails,Long> {


   @Query("select p.passenger_details_id from PassengerDetails p where p.email=:email ")
    Long getIdPassengerDetails(String email );
//    PassengerDetails findPassengerDetailsByPassportNo(int passportNo );
}
