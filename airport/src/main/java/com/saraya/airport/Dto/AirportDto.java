package com.saraya.airport.model;

import lombok.Data;

@Data
public class AirportDto {
    private Long id;
    private Long airportgeoId;
    private String iata;
    private String icao;
    private String airportName;
    private String country;
    private String city;
}
