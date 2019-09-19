package com.company.services;

import com.company.models.IrregularPolygon;
import com.company.models.Polygon;
import com.company.models.RegularPolygon;

public class PolygonServiceImpl implements PolygonService {
    public boolean validateNumberOfSides(int sides){
        if(sides>=3 && sides<=10){
            return true;
        }
        else{
            return false;
        }
    }
    public void calculatePerimeter(Polygon polygon){
        if(polygon.getType().equalsIgnoreCase("regular")){
            RegularPolygon regularPolygon = (RegularPolygon)polygon;
            regularPolygon.setPerimeter(regularPolygon.getNumberOfSides()*regularPolygon.getLengthOfSide());
        }
        else{
            IrregularPolygon irregularPolygon = (IrregularPolygon)polygon;
            int perimeter = 0 , lengths[] = irregularPolygon.getLengthsOfSides();
            for(int i=0;i<lengths.length;i++){
                perimeter = perimeter + lengths[i];
            }
            irregularPolygon.setPerimeter(perimeter);
        }
    }

}
