package com.saraya.employeeservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
public class Employee {
    @Transient
    private static long id;
    @Id
    private String empNo;

    private String fullName;

    @Column(columnDefinition = "date")
    private LocalDate hiredate;

    private String job;

    private double salary;

    private double advantageRate;

    private String deptId;

    public Employee() {
    }

    public Employee(String fullName, LocalDate hiredate, String job, double salary, double advantageRate, String deptId) {
        generateEmpNo();
        this.fullName = fullName;
        this.hiredate = hiredate;
        this.job = job;
        this.salary = salary;
        this.advantageRate = advantageRate;
        this.deptId = deptId;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        Employee.id = id;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getAdvantageRate() {
        return advantageRate;
    }

    public void setAdvantageRate(double advantageRate) {
        this.advantageRate = advantageRate;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    private void generateEmpNo() {
        this.empNo="EMP_NO-" + ++id;
    }


    public void currentAdvantageRate(){
        int spentYears = LocalDate.now().getYear() - this.getHiredate().getYear();
        if (spentYears>= 3 && spentYears<5){
            this.setAdvantageRate(5);
        }
       else if (spentYears>= 5 && spentYears<10){
            this.setAdvantageRate(6.5);
        }
        else if (spentYears>=10 ){
            this.setAdvantageRate(9);
        }
        else{
            this.setAdvantageRate(0);
        }
    }

}
