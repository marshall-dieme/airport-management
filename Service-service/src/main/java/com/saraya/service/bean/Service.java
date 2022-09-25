package com.saraya.service.bean;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serviceId;

    private String name;


}
