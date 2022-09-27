package com.saraya.Airplane_Type.dto;

import lombok.Data;

@Data
public class AirplaneTypeToAirplaneDTO {
    
    private Long airplane_type_id;
     private String  capacity;
     private String airplane_type_identifier;
     private String description;

}