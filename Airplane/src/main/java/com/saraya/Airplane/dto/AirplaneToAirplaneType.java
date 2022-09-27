package com.saraya.Airplane.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter  @Setter
public class AirplaneToAirplaneType {
    
    private Long airplane_id;
     private String  capacity;
     private String airplane_type_identifier;
     private String description;
}