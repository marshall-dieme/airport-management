package com.vlm.airplanetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vlm.airplanetype.model.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
