package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Retangulo;

public class Program {

	public static void main(String[] args) {
		
		// prar colocar a connversion americana
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		Retangulo retangulo = new Retangulo();
		
		System.out.println("Enter rectangle width and height:");
		retangulo.largura = sc.nextDouble();
		retangulo.comprimento = sc.nextDouble();
		
		//A saida
		
		System.out.printf("AREA = %.2f%n", retangulo.area());
		System.out.printf("Perimeter = %.2f%n", retangulo.perimetro());
		System.out.printf("Diagonal = %.2f%n", retangulo.diagonal());

		sc.close();
	}

}
