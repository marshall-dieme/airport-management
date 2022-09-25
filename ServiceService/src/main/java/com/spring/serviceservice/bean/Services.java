package com.spring.serviceservice.bean;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class Services{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;

    private int airportId;

    private String iata;

    private String iacao;

    @Column(unique = true)
    private  String airportName;





    public Services() {
    }

    public Services(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
