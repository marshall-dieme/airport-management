package com.saraya.airplane_type.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Airplane_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_type_id;

    @Column(unique = true)
    private String airplane_type_identifier;

    private String description;

    private Long airplane_id;
}
