package com.saraya.Airplane.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
public class AirplaneType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long airplane_type_id;
        private String airplane_type_identifier;
        private String description;



}