package com.company.services.impl;

import com.company.models.IrregularPolygon;
import com.company.models.Polygon;
import com.company.models.RegularPolygon;
import com.company.services.PolygonService;

public class PolygonServiceImpl implements PolygonService {
    public boolean validateNumberOfSides(int sides) {
        return (sides >= 3 && sides <= 10) ? true : false;
    }

    public void calculatePerimeter(Polygon polygon) {
        if (polygon.getType().equalsIgnoreCase("regular")) {
            RegularPolygon regularPolygon = (RegularPolygon) polygon;
            regularPolygon.setPerimeter(regularPolygon.getNumberOfSides() * regularPolygon.getLengthOfSide());
        } else {
            IrregularPolygon irregularPolygon = (IrregularPolygon) polygon;
            int perimeter = 0, lengths[] = irregularPolygon.getLengthsOfSides();
            for (int i = 0; i < lengths.length; i++) {
                perimeter = perimeter + lengths[i];
            }
            irregularPolygon.setPerimeter(perimeter);
        }
    }
}
