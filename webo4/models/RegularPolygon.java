package com.company.models;

public class RegularPolygon extends Polygon {
    private int lengthOfSide;

    public RegularPolygon() {
    }

    public RegularPolygon(int numberOfSides, String type, int lengthOfSide) {

        super(numberOfSides, type);
        this.lengthOfSide = lengthOfSide;
    }

    public int getLengthOfSide() {
        return lengthOfSide;
    }

    public void setLengthOfSide(int lengthOfSide) {
        this.lengthOfSide = lengthOfSide;
    }

}
