package com.saraya.airplane_type.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Airplane_type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airplane_type_id;
    private String  airplane_type_identifier;
    private String description;
    private long airplane_id;
}
