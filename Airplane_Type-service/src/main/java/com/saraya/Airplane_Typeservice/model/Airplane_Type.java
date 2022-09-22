package com.saraya.Airplane_Typeservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Airplane_Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_type_id;

    @Column(unique = true)
    private String airplane_type_identifier;

    private String description;

    private Long airplane_id;
}
