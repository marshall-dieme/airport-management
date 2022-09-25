package com.saraya.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.parking.model.Rentals;
@Repository
public interface RenaltesRepository extends JpaRepository<Rentals, Long> {

}
