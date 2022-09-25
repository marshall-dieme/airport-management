package com.saraya.Airport.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airport_id;
    private String iata;
    private String icao;
    private String airport_name;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "service_id")
    private Services service;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    public String getAirline_name() {
        return null;
    }

    
}