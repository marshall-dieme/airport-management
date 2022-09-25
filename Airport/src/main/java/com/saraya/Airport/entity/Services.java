package com.saraya.Airport.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
// @ToString
@Table(name = "services_service")
public class Services implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long services_id;
    private String services_name;
    
    
}