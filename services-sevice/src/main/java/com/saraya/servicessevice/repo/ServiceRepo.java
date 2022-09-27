package com.saraya.servicessevice.repo;

import com.saraya.servicessevice.bean.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Services, Integer> {
    Services findByName(String name);
}
