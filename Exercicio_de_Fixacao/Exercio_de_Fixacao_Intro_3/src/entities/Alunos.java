package entities;

public class Alunos {
	public String name;
	public double quarter1; // trimestre = quarter
	public double quarter2;
	public double quarter3;
	
	public double finalQuarter() {
		return quarter1 + quarter2 + quarter3; // a soma dos trimestre
	}
	
	public double missingPoints() {
		if(finalQuarter() < 60.0) 
			return 60.0 - finalQuarter();
		else
			return 0.0;
	}
	
}
