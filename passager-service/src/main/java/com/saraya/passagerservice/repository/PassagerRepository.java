package com.saraya.passagerservice.repository;

import com.saraya.passagerservice.model.Passager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassagerRepository extends JpaRepository<Passager , Integer> {

    Passager findByFirstNameAndLastName(String firstName, String lastName);
}
