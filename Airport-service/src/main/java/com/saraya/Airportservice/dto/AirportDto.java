package com.saraya.Airportservice.dto;

import lombok.Data;

@Data
public class AirportDto {
    private Long airport_id;
    private String iata;
    private String icao;
    private String airport_name;
    private String airport_geo_country;
    private String airport_geo_city;
    private String service_name;
    private String airline_name;
}
