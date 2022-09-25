package com.spring.PassengerDetail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.spring.PassengerDetail.bean.PassengerDetail;
import com.spring.PassengerDetail.repo.PassengerDetailRepo;

@Service
public class PassengerDetailService {
	@Autowired
	private PassengerDetailRepo repository ;
	
	
	public List<PassengerDetail> getAll()
	{
		return repository.findAll();
		
	}
	
	public PassengerDetail create (PassengerDetail passengerdetail) {
		return repository.save(passengerdetail);
	}

	
	public PassengerDetail update ( PassengerDetail passengerdetail) {
		return repository.save(passengerdetail);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
		
	}
}

