package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quantos numeros voce vai digitar? ");
		int n = sc.nextInt();
		int[] vet = new int[n];
		int cont = 0;
		
		for(int i = 0; i<n; i++) {
			System.out.print("Digite um numero: ");
			vet[i] = sc.nextInt();
		}
		
		System.out.println("\nNumeros pares: ");
		for(int i=0; i<n; i++) {
			if(vet[i] % 2 ==0) {
				System.out.printf("%d ", vet[i]);
				cont+=1;
			}
		}
		System.out.printf("\n\n Quantidade de pares = %d\n", cont);
		
		sc.close();
	}

}
