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

