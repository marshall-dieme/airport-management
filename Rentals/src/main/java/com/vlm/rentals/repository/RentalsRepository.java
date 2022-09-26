package com.vlm.rentals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.rentals.model.Rentals;

@Repository
public interface RentalsRepository extends JpaRepository<Rentals, Long> {

}
