package com.saraya.pasanger_details.repo;

import com.saraya.pasanger_details.model.PasangerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PasangerDetailsRepository extends JpaRepository<PasangerDetails, Double> {
    @Query("select p from PasangerDetails p")
    List<PasangerDetails> getIdPasangerDetailsBybirthdateAndsexAndstreetAndcityAndzipAndcountryAndemailAndtelephone();

    Double getIdPasangerDetailsBybirthdateAndsexAndstreetAndcityAndzipAndcountryAndemailAndtelephone(LocalDate birthdate, String sex, String street, String city, String zip, String country, String email, int telephone);

    void deleteBybirthdateAndsexAndstreetAndcityAndzipAndcountryAndemailAndtelephone(LocalDate birthdate, String sex, String street, String city, String zip, String country, String email, int telephone);
}
