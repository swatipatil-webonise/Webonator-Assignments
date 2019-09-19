package com.company;

import com.company.models.IrregularPolygon;
import com.company.models.Polygon;
import com.company.models.RegularPolygon;
import com.company.services.PolygonService;
import com.company.services.PolygonServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PolygonServiceImpl service = new PolygonServiceImpl();
        Polygon polygon = null;
        System.out.println("Choose one : \n1 Regular Polygon\n2 Irregular Polygon");
        String type = scan.next();
        System.out.println("Enter the number of sides : ");
        int sides = scan.nextInt();
        boolean valid = service.validateNumberOfSides(sides);
        if (valid) {
            if (type.equalsIgnoreCase("regular")) {
                RegularPolygon regularPolygon = new RegularPolygon();
                regularPolygon.setType(type);
                regularPolygon.setNumberOfSides(sides);
                System.out.println("Enter the length of side : ");
                regularPolygon.setLengthOfSide(scan.nextInt());
                polygon = regularPolygon;
            } else {
                IrregularPolygon irregularPolygon = new IrregularPolygon();
                irregularPolygon.setType(type);
                irregularPolygon.setNumberOfSides(sides);
                int lengths[] = new int[irregularPolygon.getNumberOfSides()];
                System.out.println("Enter the lengths of sides : ");
                for (int i = 0; i < lengths.length; i++) {
                    lengths[i] = scan.nextInt();
                }
                irregularPolygon.setLengthsOfSides(lengths);
                polygon = irregularPolygon;
            }
            service.calculateSumOfInterierAngles(polygon);
            service.calculateSumOfInterierAngles(polygon);
            service.calculatePerimeter(polygon);
            System.out.println("Sum of interier angles : " + polygon.getSumOfInterierAngles());
            System.out.println("Perimeter : " + polygon.getPerimeter());
            return;
        } else {
            System.out.println("Sry number of side is invalid.(3-10)");
            return;
        }
    }
}
