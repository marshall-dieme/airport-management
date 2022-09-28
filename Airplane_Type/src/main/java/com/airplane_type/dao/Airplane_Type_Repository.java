package com.airplane_type.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airplane_type.entities.Airplane_Type;

@Repository
public interface Airplane_Type_Repository extends JpaRepository<Airplane_Type, Long>{

}
