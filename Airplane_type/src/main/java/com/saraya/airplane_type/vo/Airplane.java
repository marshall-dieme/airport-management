package com.saraya.airplane_type.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Airplane {

    private long airplane_id;
    private String airplane_capacity;
    private long airline_id;
    private long airplane_type_id;
    private long flight_id;


}
