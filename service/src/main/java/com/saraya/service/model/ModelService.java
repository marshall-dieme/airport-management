package com.saraya.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ModelService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long service_id;
    private String service_name;
    private long airport_id;
}
