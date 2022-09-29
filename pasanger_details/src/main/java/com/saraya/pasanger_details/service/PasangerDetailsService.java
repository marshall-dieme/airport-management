package com.saraya.pasanger_details.service;

import com.saraya.pasanger_details.model.PasangerDetails;
import com.saraya.pasanger_details.repo.PasangerDetailsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PasangerDetailsService {
    private final PasangerDetailsRepository repo;

    public PasangerDetailsService(PasangerDetailsRepository repo) {
        this.repo = repo;
    }
   public List<PasangerDetails> getAll(){
        return repo.findAll();
   }
   public PasangerDetails create(PasangerDetails pasangerDetails){
        return repo.save(pasangerDetails);
   }
    public PasangerDetails update(PasangerDetails pasangerDetails){
        return repo.save(pasangerDetails);
    }
   public void delete(Double id){
        repo.deleteById(id);
   }
   public Double getIdPasangerDetails( LocalDate birthdate,
    String sex,
      String street,
      String city,
      String zip,
      String country,
     String email,
      int telephone
){
     return repo.getIdPasangerDetailsBybirthdateAndsexAndstreetAndcityAndzipAndcountryAndemailAndtelephone(birthdate, sex,
              street,
              city,
              zip,
              country,
              email,
        telephone);
   }
   public  void deleteBybirthdateAndsexAndstreetAndcityAndzipAndcountryAndemailAndtelephone(LocalDate birthdate, String sex,
                                                                                             String street,
                                                                                             String city,
                                                                                             String zip,
                                                                                             String country,
                                                                                             String email,
                                                                                             int telephone){
        repo.deleteBybirthdateAndsexAndstreetAndcityAndzipAndcountryAndemailAndtelephone( birthdate, sex, street,
                city,
                zip,
                country,
                email,
                telephone);
   }
}
