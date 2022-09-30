package com.saraya.airplanetypeservice.repos;

import com.saraya.airplanetypeservice.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<Type, Long> {
    @Query("select t.typeId from Type t where t.airplaneTypeIdentifier=:airplaneTypeIdentifier")
    Long getTypeId(String airplaneTypeIdentifier);
}
