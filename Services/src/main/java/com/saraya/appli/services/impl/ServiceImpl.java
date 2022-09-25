package com.saraya.appli.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.appli.dto.ServicesDTO;
import com.saraya.appli.mapper.convertServices;
import com.saraya.appli.model.ServicesEntity;
import com.saraya.appli.repository.ServicesRepository;
import com.saraya.appli.services.ServicesE;
@Service
public class ServiceImpl implements ServicesE {
	@Autowired
	private convertServices convertServices;
	@Autowired
	ServicesRepository repository;
	@Override
	public ServicesDTO createService(ServicesDTO dto) {
		ServicesEntity se = convertServices.dtoTOEntity(dto);
		repository.save(se);
		dto = convertServices.EntityTOdto(se);
		return dto;
	}

	@Override
	public List<ServicesDTO> getAllServices() {
		List<ServicesEntity> se = repository.findAll();
		List<ServicesDTO> listdto = new ArrayList<>();
		for (ServicesEntity serviceEntity : se) {
			ServicesDTO dto = convertServices.EntityTOdto(serviceEntity);
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public ServicesDTO showService(Long id) {
		Optional<ServicesEntity> se = repository.findById(id);
		ServicesDTO dto = null;
		if(se.isPresent()) {
			 dto = convertServices.EntityTOdto(se.get());
		}else {
			throw new RuntimeException("Did not find services id => " + id);
		}
		return dto;
	}

	@Override
	public ServicesDTO updateServices(ServicesDTO dto, Long id) {
		Optional<ServicesEntity> se = repository.findById(id);
		ServicesDTO sdto = null;
		if(se.isPresent()) {
			ServicesEntity entityService = se.get();
			entityService.setServices_name(dto.getServices_name());
			sdto = convertServices.EntityTOdto(entityService);
			repository.save(entityService);
		}
		return sdto;	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
