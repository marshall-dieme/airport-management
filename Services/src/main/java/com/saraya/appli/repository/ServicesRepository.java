package com.saraya.appli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.appli.model.ServicesEntity;
@Repository
public interface ServicesRepository extends JpaRepository<ServicesEntity, Long>{

}
