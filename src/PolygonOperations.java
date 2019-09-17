
import java.util.*;

interface Shape{
	public int sumOfInteriorAngles();
	public int calcPerimeter();
}

abstract class Polygon implements Shape{
	public String type;
	public int numberOfSides;
}

class RegularPolygon extends Polygon{
	public int lengthOfSide;
	public int degreeOfAngle;
	
	public RegularPolygon(){}
	public RegularPolygon(int lengthOfSide,int numberOfSides,int angle){
		this.lengthOfSide = lengthOfSide;
		this.numberOfSides = numberOfSides;
		this.degreeOfAngle = degreeOfAngle;	
	}
	public int sumOfInteriorAngles(){
		return this.numberOfSides*this.degreeOfAngle;
	}
	public int calcPerimeter(){
		return this.numberOfSides*this.lengthOfSide;
	}
}

class IrregularPolygon extends Polygon{
	public int lengthsOfSides[];
	public int degreesOfAngles[];
	
	public IrregularPolygon(){}
	public IrregularPolygon(int lengthsOfSides[],int numberOfSides,int degreesOfAngles[]){
		this.lengthsOfSides = lengthsOfSides;
		this.numberOfSides = numberOfSides;
		this.degreesOfAngles = degreesOfAngles;	
	}
	public int sumOfInteriorAngles(){
		int sumOfAngles = 0;
		for(int i=0;i<numberOfSides;i++){
			sumOfAngles = sumOfAngles + this.degreesOfAngles[i];
		}
		return sumOfAngles;
	}
	public int calcPerimeter(){
		int perimeter = 0;
		for(int i=0;i<numberOfSides;i++){
			perimeter = perimeter + this.lengthsOfSides[i];
		}
		return perimeter;
	}

} 

class Validations{
	public int checkSides(int sides){
		if(sides>=3 && sides<=10)
			return 0;
		else 
			return 1;
	}

}

class PerformPolygonOpns{
	private Validations validation = new Validations();
	private Scanner scan = new Scanner(System.in);
	private int check;

	public void regularPoly(){
		RegularPolygon regularPolygon = new RegularPolygon();
		regularPolygon.type = "regular";
		System.out.println("Enter the number of sides : ");
		regularPolygon.numberOfSides = scan.nextInt();
		check = validation.checkSides(regularPolygon.numberOfSides);
		if(check==1){
			System.out.println("Please choose a polygon having sides>=3 and sides<=10");
			return;
		}
		System.out.println("Enter the length of sides : ");
		regularPolygon.lengthOfSide = scan.nextInt();
		System.out.println("Enter the angle between two sides : ");
		regularPolygon.degreeOfAngle = scan.nextInt();
		System.out.println("Sum of angles of polygon = " + regularPolygon.sumOfInteriorAngles());
		System.out.println("Perimeter of polygon = " + regularPolygon.calcPerimeter());
	}
	public void irregularPoly(){	
		IrregularPolygon irregularPolygon = new IrregularPolygon();
		irregularPolygon.type = "irregular";
		System.out.println("Enter the number of sides of polygon : ");
		irregularPolygon.numberOfSides = scan.nextInt();
		check = validation.checkSides(irregularPolygon.numberOfSides);
		if(check==1){
			System.out.println("Please choose a polygon having sides>=3 and sides<=10");
			return;
		}
		irregularPolygon.lengthsOfSides = new int[irregularPolygon.numberOfSides];
		irregularPolygon.degreesOfAngles = new int[irregularPolygon.numberOfSides];
		System.out.println("Enter the lengths of sides of polygon : ");
		for(int i=0;i<irregularPolygon.numberOfSides;i++){
			irregularPolygon.lengthsOfSides[i] = scan.nextInt();
		}
		System.out.println("Enter the angles of polygon : ");
		for(int i=0;i<irregularPolygon.numberOfSides;i++){
			irregularPolygon.degreesOfAngles[i] = scan.nextInt();
		}
		System.out.println("Sum of angles of polygon = " + irregularPolygon.sumOfInteriorAngles());
		System.out.println("Perimeter of polygon = " + irregularPolygon.calcPerimeter());
	}	
}

class PolygonOperations{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose your choice \n1.Regular Polygon\n2.Irregular Polygon");
		String type = scan.next();
		PerformPolygonOpns performPolygonOpns = new PerformPolygonOpns();
		switch(type){
			case "regular":
				performPolygonOpns.regularPoly();
				break;

			case "irregular":
				performPolygonOpns.irregularPoly();
				break;
		}
	}
}
