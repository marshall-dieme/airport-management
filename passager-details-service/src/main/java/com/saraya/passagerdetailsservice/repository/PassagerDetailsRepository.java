package com.saraya.passagerdetailsservice.repository;

import com.saraya.passagerdetailsservice.model.PassagerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagerDetailsRepository extends JpaRepository<PassagerDetails , Integer> {

    PassagerDetails findByEmail(String email);
}
