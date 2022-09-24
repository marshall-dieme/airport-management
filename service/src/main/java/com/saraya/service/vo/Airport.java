package com.saraya.service.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airport {

    private long airport_id;
    private String iata;
    private String icao;
    private  String airport_name;
    private long airport_geo_id;
}
