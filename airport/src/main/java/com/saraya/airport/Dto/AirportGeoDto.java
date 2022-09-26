package com.saraya.airport.Dto;

import lombok.Data;

@Data
public class AirportGeoDto {
    private Long airport_geo_id;
    private String country;
    private String city;
}
