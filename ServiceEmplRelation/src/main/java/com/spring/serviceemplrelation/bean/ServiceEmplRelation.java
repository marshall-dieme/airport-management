package com.spring.serviceemplrelation.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ServiceEmplRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRelation;

    private int EmployeeId;

    private int idService;

    public ServiceEmplRelation() {
    }

    public ServiceEmplRelation(int idRelation, int employeeId, int idService) {
        this.idRelation = idRelation;
        EmployeeId = employeeId;
        this.idService = idService;
    }

    public int getIdRelation() {
        return idRelation;
    }

    public void setIdRelation(int idRelation) {
        this.idRelation = idRelation;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }
}
