package com.company.models;

public class RegularPolygon extends Polygon {
    private int lengthOfSide;

    public RegularPolygon() {
    }

    public RegularPolygon(int lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

    public int getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(int lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

}
