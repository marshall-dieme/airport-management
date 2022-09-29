package com.saraya.airline.vo;


import com.saraya.airline.model.Airline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplateVo {


    private Airline airline;
    private Airplane airplane;

}
