package com.saraya.passengerdetailsservice.repos;

import com.saraya.passengerdetailsservice.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepo extends JpaRepository <Detail, Long> {
    Detail findByPassengerId(Long passengerId);
}
