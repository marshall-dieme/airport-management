package com.saraya.service.vo;

import com.saraya.service.model.ModelService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplateVo {

    private ModelService modelService;
    private  Airport airport;

}

