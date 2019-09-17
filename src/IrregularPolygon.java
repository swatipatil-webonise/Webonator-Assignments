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
