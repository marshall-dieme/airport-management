package com.saraya.employeeservice.dto;

public class AdvantageDto {
    private int spentYearsMin;
    private int spentYearsMax;
    private double adRate;

    public int getSpentYearsMin() {
        return spentYearsMin;
    }

    public void setSpentYearsMin(int spentYearsMin) {
        this.spentYearsMin = spentYearsMin;
    }

    public int getSpentYearsMax() {
        return spentYearsMax;
    }

    public void setSpentYearsMax(int spentYearsMax) {
        this.spentYearsMax = spentYearsMax;
    }

    public double getAdRate() {
        return adRate;
    }

    public void setAdRate(double adRate) {
        this.adRate = adRate;
    }
}
