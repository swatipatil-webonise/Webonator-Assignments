package com.company.models;

public class IrregularPolygon extends Polygon {
    private int[] lengthsOfSides;

    public IrregularPolygon() {
    }

    public IrregularPolygon(int numberOfSides, String type, int[] lengthsOfSides) {
        super(numberOfSides, type);
        this.lengthsOfSides = lengthsOfSides;
    }

    public int[] getLengthsOfSides() {
        return lengthsOfSides;
    }

    public void setLengthsOfSides(int[] lengthsOfSides) {
        this.lengthsOfSides = lengthsOfSides;
    }
}
