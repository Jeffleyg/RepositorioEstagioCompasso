package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos numeros você vai digitar? ");
		int n = sc.nextInt();
		double[] vet = new double[n];
		double soma = 0.0;
		for (int i = 0; i<n; i++) {
			System.out.print("Digite um numero: ");
			vet[i] = sc.nextDouble();
			soma += vet[i];
		}
		double media = soma/n;
		System.out.println("VAlORES = ");
		
		for(int i =0; i<n; i++) {
			System.out.printf("%.1f ", vet[i]);
		}
		
		System.out.printf("\nSoma = %.2f\n", soma);
		System.out.printf("\nMedia = %.2f\n", media);
		
	}

}
