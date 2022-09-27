package com.saraya.Airportservice.dto;

import lombok.Data;

@Data
public class AirportDto {
    private Long airport_id;
    private String iata;
    private String icao;
    private String airport_name;
    private Long airport_geo_id;
    private Long service_id;
    private Long airline_id;
}
