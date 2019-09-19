package com.company;

import com.company.models.IrregularPolygon;
import com.company.models.Polygon;
import com.company.models.RegularPolygon;
import com.company.services.impl.PolygonServiceImpl;

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
                System.out.println("Enter the length of side : ");
                polygon = new RegularPolygon(sides, type, scan.nextInt());;
            } else {
                System.out.println("Enter the lengths of sides : ");
                int lengths[] = new int[sides];
                for (int i = 0; i < lengths.length; i++) {
                    lengths[i] = scan.nextInt();
                }
                polygon = new IrregularPolygon(sides, type, lengths);
            }
            service.calculateSumOfInterierAngles(polygon);
            service.calculatePerimeter(polygon);
            System.out.println("Sum of interier angles : " + polygon.getSumOfInterierAngles());
            System.out.println("Perimeter : " + polygon.getPerimeter());
            return;
        } else {
            System.out.println("Sorry number of side is invalid.(3-10)");
            return;
        }
    }
}
