package com.company.models;

public class Polygon extends Shape {
    private int sumOfInterierAngles;
    private int numberOfSides;
    private String type;

    public Polygon() {
    }

    public int getSumOfInterierAngles() {
        return sumOfInterierAngles;
    }

    public void setSumOfInterierAngles(int sumOfInterierAngles) {
        this.sumOfInterierAngles = sumOfInterierAngles;
    }

    public int getNumberOfSides() {
        return numberOfSides;
    }

    public void setNumberOfSides(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
