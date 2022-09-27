package com.saraya.PassengerDetailsservice.service;

import com.saraya.PassengerDetailsservice.dto.PassengerDetailsDto;
import com.saraya.PassengerDetailsservice.mapper.Mapper;
import com.saraya.PassengerDetailsservice.model.PassengerDetails;
import com.saraya.PassengerDetailsservice.repository.PassengerDetailsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class PassengerDetailService {

    private final PassengerDetailsRepo repo;

    private final Mapper mapper;

    public List<PassengerDetailsDto> getAllPassengerDetails() {
        return repo.findAll()
                .stream().map(mapper::mapToDto)
                .toList();
    }

    public PassengerDetails getPassengerDetails(Long passenger_details_id) {
        return repo.findById(passenger_details_id).orElseThrow();

    }

    public PassengerDetails savePassengerDetails(PassengerDetailsDto dto) {
        PassengerDetails details = mapper.mapToEntity(dto);
        log.debug(dto.toString());
        return repo.save(details);
    }

    public PassengerDetails updatePassengerDetails(PassengerDetailsDto dto) {
        PassengerDetails details = mapper.mapToEntity(dto);
        log.debug(dto.toString());
        return repo.save(details);
    }

    public void deletePassengerDetails(Long passenger_details_id) {
        repo.deleteById(passenger_details_id);
    }

}
