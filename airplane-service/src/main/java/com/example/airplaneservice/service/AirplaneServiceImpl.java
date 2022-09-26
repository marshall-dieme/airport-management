package com.example.airplaneservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.airplaneservice.model.Airplane;
import com.example.airplaneservice.model.AirplaneDTO;
import com.example.airplaneservice.repository.AirplaneRepository;


@Service
public class AirplaneServiceImpl implements AirplaneService {

	@Autowired
	private ModelMapper modelmapper;
	
	private final AirplaneRepository repo;
	
	public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
		repo = airplaneRepository;
	}
	@Override
	public List<AirplaneDTO> getAllAirplane() {
		// TODO Auto-generated method stub
		List<Airplane> airplane = (List<Airplane>) repo.findAll();
		List<AirplaneDTO> airplAiplaneDTOs = new ArrayList<>();
		
		for(Airplane airp: airplane) {
			AirplaneDTO dto = entityToDTO(airp);
			airplAiplaneDTOs.add(dto);
		}
		return airplAiplaneDTOs;
	}

	@Override
	public AirplaneDTO getAirplaneById(Long id) {
		// TODO Auto-generated method stub
		Optional<Airplane> result = repo.findById(id);
		Airplane airplane = null;
		if(result.isPresent()) {
			airplane = result.get();
		}
		else {
			throw new RuntimeException("Didn't find Airplane with id " +id);
		}
		AirplaneDTO airplaneDTO = entityToDTO(airplane);
		return airplaneDTO;
	}

	@Override
	public AirplaneDTO createAirplane(AirplaneDTO airplaneDTO) {
		// TODO Auto-generated method stub
		Airplane airplane = new Airplane();
		AirplaneDTO airplaneDto = entityToDTO(repo.save(airplane));
		return airplaneDto;
	}

	@Override
	public AirplaneDTO updateAiplane(AirplaneDTO airplaneDTO, Long id) {
		// TODO Auto-generated method stub
		AirplaneDTO airpDto = null;
		Optional<Airplane> airplane = repo.findById(id);
		if(airplane.isPresent()) {
			Airplane airp = airplane.get();
			airp.setCapacity(airplaneDTO.getCapacity());
			airpDto = entityToDTO(airp);
			
		}
		return airpDto;
	}

	@Override
	public void deleteAirplane(Long id) {
		// TODO Auto-generated method stub
			repo.deleteById(id);
	}
	
	private AirplaneDTO entityToDTO(Airplane airplane) {
		AirplaneDTO dto = modelmapper.map(airplane, AirplaneDTO.class);
		return dto;
	}
	
	private Airplane dtoToEntity(AirplaneDTO dto) {
		Airplane airplane = modelmapper.map(dto, Airplane.class);
		return airplane;
	}
	
}
