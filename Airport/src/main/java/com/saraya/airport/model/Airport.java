package com.saraya.airport.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airport_id;
    private String iata;
    private String icao;
    private String airport_name;
    private long airport_geo_id;
    private long service_id;
    private long airline_id;
}
