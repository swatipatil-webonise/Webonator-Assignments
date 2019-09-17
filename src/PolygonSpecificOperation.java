import java.util.Scanner;

class PolygonSpecificOperation{
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

