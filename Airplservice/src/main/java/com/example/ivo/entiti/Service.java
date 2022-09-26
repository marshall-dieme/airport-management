package com.example.ivo.entiti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Table(name="services")
@Data 
@NoArgsConstructor
@AllArgsConstructor 
 @ToString
public class Service {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id_service")
private long id_service;
	@Column(name="service_name")
private String service_name;

}
