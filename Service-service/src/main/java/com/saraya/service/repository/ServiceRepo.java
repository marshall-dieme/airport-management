package com.saraya.service.repository;

import com.saraya.service.bean.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Integer> {
    Service findByServiceId(int id);
}
