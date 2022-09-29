package com.regulus.rentalservice.repositories;

import com.regulus.rentalservice.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

    @Query("select b.rental_id from Rental b where b.name=:name")
    Integer findByName(String name);
}
