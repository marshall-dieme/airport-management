package com.saraya.airplane.vo;

import com.saraya.airplane.model.Airplane;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVo {

    private Airline airline;
    private Airplane airplane;
}
