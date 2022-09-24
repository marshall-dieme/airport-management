package com.saraya.Airport_Geoservice.model;

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
public class Airport_Geo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airport_geo_id;

    @Column(unique = true)
    private String country;

    @Column(unique = true)
    private String city;
}
