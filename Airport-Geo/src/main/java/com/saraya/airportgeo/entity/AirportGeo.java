package com.saraya.airportgeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;


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
