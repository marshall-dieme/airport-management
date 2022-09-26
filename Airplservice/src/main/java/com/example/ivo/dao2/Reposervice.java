package com.example.ivo.dao2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ivo.entiti.Service;
@Repository

public interface Reposervice  extends JpaRepository<Service , Long> {

}
