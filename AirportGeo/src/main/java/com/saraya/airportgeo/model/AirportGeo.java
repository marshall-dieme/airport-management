package com.saraya.airportgeo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirportGeo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airport_geo_id;
    private String country;
    private String city;
}