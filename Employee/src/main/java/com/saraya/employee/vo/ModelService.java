package com.saraya.employee.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelService {

    private long service_id;
    private String service_name;
    private long airport_id;
}
