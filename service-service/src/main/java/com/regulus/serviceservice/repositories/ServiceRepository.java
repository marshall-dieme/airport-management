package com.regulus.serviceservice.repositories;


import com.regulus.serviceservice.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

    @Query("select s.service_id from Service s where s.service_name=:name")
    Integer findByService_name(String name);
}
