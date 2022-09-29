package com.regulus.passengerdetailservice.services;

import com.regulus.passengerdetailservice.dtos.PassengerDetailsDto;
import com.regulus.passengerdetailservice.models.PassengerDetails;
import com.regulus.passengerdetailservice.repositories.PassengerDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class PassengerDetailsService {

    private final PassengerDetailsRepository repository;

    private final RestTemplate restTemplate;
    private final Mapper mapper;

    public PassengerDetailsService(PassengerDetailsRepository repository, RestTemplate restTemplate, Mapper mapper) {
        this.repository = repository;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public List<PassengerDetails> getPassengerDetails(){
        return repository.findAll();
    }

    public PassengerDetailsDto getPassengerDetails(int id){
        PassengerDetails details =  repository.findById(id).get();
        return mapper.toDto(details);
    }

    public PassengerDetailsDto createPassengerDetails(PassengerDetailsDto detailsDto){
        Integer passengerId = restTemplate.getForEntity("http://passenger-service/passenger/passport/" + detailsDto.getPassenger_passport_no(),
                Integer.class).getBody();
        assert  passengerId != null;
        detailsDto.setPassenger_id(passengerId);
        PassengerDetails details = mapper.toEntity(detailsDto);
        details =  repository.save(details);
        return mapper.toDto(details);
    }

    public PassengerDetailsDto updatePassengerDetails(PassengerDetailsDto detailsDto, int id){
        PassengerDetailsDto detailsDto1 = getPassengerDetails(id);
        PassengerDetails details = mapper.toEntity(detailsDto1);
        details.setPassenger_details_id(detailsDto.getPassenger_details_id());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        details.setBirthDate(LocalDate.parse(detailsDto.getBirthDate(), formatter));
        details.setSex(detailsDto.getSex());
        details.setStreet(detailsDto.getStreet());
        details.setCity(detailsDto.getCity());
        details.setZip(detailsDto.getZip());
        details.setContry(detailsDto.getContry());
        details.setEmail(detailsDto.getEmail());
        details.setTelephone(detailsDto.getTelephone());
        details.setPassenger_id(detailsDto.getPassenger_id());
        details = repository.save(details);
        return mapper.toDto(details);
    }

    public void deletePassengerDetails(int id){
        PassengerDetailsDto detailsDto = getPassengerDetails(id);
        PassengerDetails details = mapper.toEntity(detailsDto);
        repository.delete(details);
    }


}
