package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		method2();
		
		System.out.println("End of program");

	}
	
	public static void method2() {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			String[] vect = sc.nextLine().split(" ");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}
		catch(ArrayIndexOutOfBoundsException e) { // para validar position não valido
			System.out.println("Invalid position");
		}
		catch(InputMismatchException e) { // para validar quando colocar um input errado
			System.out.println("Input error");
		}
		sc.close();
	}
	

}
