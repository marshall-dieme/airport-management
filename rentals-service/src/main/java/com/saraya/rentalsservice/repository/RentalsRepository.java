package com.saraya.rentalsservice.repository;

import com.saraya.rentalsservice.model.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals , Integer> {
    Rentals findByLicenceNo(String licenceNo);
}
