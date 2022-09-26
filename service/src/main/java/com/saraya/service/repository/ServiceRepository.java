package com.saraya.service.repository;

import com.saraya.service.model.ModelService;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<ModelService, Long> {
    //@Query(value = "select d.service_id from ModelService d where d.name=:name ", nativeQuery = true)
//    String getIdService(String service_name);

    ModelService findById(long service_id);
}
