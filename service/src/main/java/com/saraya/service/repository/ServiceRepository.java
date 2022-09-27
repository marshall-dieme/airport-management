package com.saraya.service.repository;

import com.saraya.service.model.ModelService;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<ModelService, Long> {
    //@Query(value = "select d.service_id from ModelService d where d.service_name=:name ")

   // String getByServiceName(String service_name);

     ModelService findById(long service_id);

    //void deleteById(ModelService modelService);
}
