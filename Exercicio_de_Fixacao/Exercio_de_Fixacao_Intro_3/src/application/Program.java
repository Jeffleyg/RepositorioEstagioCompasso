package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Alunos;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		Alunos aluno = new Alunos(); // a chamada da função Alunos
		
		aluno.name = sc.nextLine();
		aluno.quarter1 = sc.nextDouble();
		aluno.quarter2 = sc.nextDouble();
		aluno.quarter3 = sc.nextDouble();
		
		// out
		System.out.printf("Final GRADE: %.2f%n", aluno.finalQuarter());
		
		if(aluno.finalQuarter() < 60.0) {
			System.out.println("FAILED");
			System.out.printf("MISSING %.2f POINTS %n", aluno.missingPoints());
		}	
		else {
			System.out.println("PASS");
		}
	}

}
