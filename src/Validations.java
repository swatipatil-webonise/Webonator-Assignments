class Validations{
	public int checkSides(int sides){
		if(sides>=3 && sides<=10){
			return 0;
		}
		else{ 
			return 1;
		}
	}

}
