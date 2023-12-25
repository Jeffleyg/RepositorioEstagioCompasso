package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos números você vai digitar: ");
		int num = sc.nextInt();
		
		// criar o vetor
		int[] vet = new int[num];
		
		// loop 
		for (int i =0; i<num; i++) {
			System.out.println("Digite um número: ");
			vet[i] = sc.nextInt();
		}
		
		// mostar os numeros negatovos
		System.out.println("Numeros negativos: ");
		for(int i=0; i<num ; i++){
			if(vet[i] < 0) {
				System.out.println(vet[i]);
			}
		}
	}

}
