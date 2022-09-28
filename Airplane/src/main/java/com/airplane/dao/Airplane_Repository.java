package com.airplane.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airplane.entities.Airplane;

@Repository
public interface Airplane_Repository extends JpaRepository<Airplane, Long>{

}
