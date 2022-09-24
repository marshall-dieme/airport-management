package com.saraya.airport.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportGeo {

    private long airport_geo_id;
    private String country;
    private String city;
}
