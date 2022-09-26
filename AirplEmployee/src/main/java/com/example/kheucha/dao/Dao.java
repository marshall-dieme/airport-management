package com.example.kheucha.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kheucha.entities.Employee;

@Repository
public interface Dao extends JpaRepository<Employee , Long> {

}
