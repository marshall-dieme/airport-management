package com.saraya.services.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saraya.services.convert.ConvertServices;
import com.saraya.services.dto.ServiceDTO;
import com.saraya.services.model.ServiceEntity;
import com.saraya.services.repository.serviceRepo;
import com.saraya.services.serviceI.Services;
@Service
public class ServicesImpl implements Services {
	@Autowired
	private serviceRepo repo;
	@Autowired
	ConvertServices convertServices;
	@Override
	public ServiceDTO createService(ServiceDTO dto) {
		ServiceEntity se = convertServices.dtoTOEntity(dto);
		repo.save(se);
		ServiceDTO sdto = convertServices.EntityTOdto(se);
		return sdto;
	}

	@Override
	public List<ServiceDTO> getAllServices() {
		List<ServiceEntity> se = repo.findAll();
		List<ServiceDTO> listdto = new ArrayList<>();
		for (ServiceEntity serviceEntity : se) {
			ServiceDTO dto = convertServices.EntityTOdto(serviceEntity);
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public ServiceDTO showService(Long id) {
		Optional<ServiceEntity> se = repo.findById(id);
		ServiceDTO dto = null;
		if(se.isPresent()) {
			 dto = convertServices.EntityTOdto(se.get());
		}else {
			throw new RuntimeException("Did not find services id => " + id);
		}
		return dto;
	}

	@Override
	public ServiceDTO updateServices(ServiceDTO dto, Long id) {
		Optional<ServiceEntity> se = repo.findById(id);
		ServiceDTO sdto = null;
		if(se.isPresent()) {
			ServiceEntity entityService = se.get();
			entityService.setServices_name(dto.getServices_name());
			sdto = convertServices.EntityTOdto(entityService);
			repo.save(entityService);
		}
		return sdto;
	}

	@Override
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
