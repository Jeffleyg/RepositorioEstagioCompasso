package curso_programacao_java;

import java.util.Scanner;
import java.lang.Math;

public class Exo2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Double x;
		Double y = 3.14;
		
		x = sc.nextDouble();
		
		Double A = y * Math.pow(x, 2);
		
		System.out.println("A = "+ A);
	
		
	}

}
