package com.saraya.airport.Dto;

import lombok.Data;

@Data
public class AirportDto {
    private Long id;
    private String iata;
    private String icao;
    private String airportName;
    private String country;
    private String city;
}
