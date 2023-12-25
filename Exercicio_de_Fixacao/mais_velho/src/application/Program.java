package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantas pessoas você vai digitar? ");
		int  n = sc.nextInt();
		
		String[] nomes = new String[n];
		
		int [] idades = new int[n];
		int maior = idades[0];
		int posicao =0;
		
		for(int i =0; i<n; i++) {
			System.out.printf("Dados da %da pessoa : \n", i+1);
			System.out.print("Nome: ");
			nomes[i] = sc.next();
			System.out.print("Idade: ");
			idades[i]= sc.nextInt();
		}
		
		for (int i = 0; i< n ; i++) {
			if(idades[i]> maior) {
				maior = idades[i];
				posicao = i;
			}
		}
		
		System.out.printf("PESSOA MAIS VELHA: %s\n", nomes[posicao]);
		
		
		
		
		sc.close();

	}

}
