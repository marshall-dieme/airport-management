package com.saraya.Services.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

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
    @Column(nullable = false, updatable = false)
    private String services_name;
    
    
}