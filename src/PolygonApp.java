import java.util.Scanner;

class PolygonApp{
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
