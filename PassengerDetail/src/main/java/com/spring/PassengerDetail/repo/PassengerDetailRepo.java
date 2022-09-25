package com.spring.PassengerDetail.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.PassengerDetail.bean.PassengerDetail;

@Repository
public interface PassengerDetailRepo extends JpaRepository<PassengerDetail, Integer> {
	

}
