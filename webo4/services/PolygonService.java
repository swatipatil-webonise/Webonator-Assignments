package com.company.services;

import com.company.models.Polygon;
import com.company.models.Shape;

public interface PolygonService extends ShapeService {
    default void calculateSumOfInterierAngles(Polygon polygon){
        polygon.setSumOfInterierAngles(180 * (polygon.getNumberOfSides()-2));
    }
}
