package com.saraya.Airplane_Type.entity;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AirplaneType implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long airplane_type_id;
        private String airplane_type_identifier;
        private String description;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "airplane_id")
        private Airplane airplane;
    


}