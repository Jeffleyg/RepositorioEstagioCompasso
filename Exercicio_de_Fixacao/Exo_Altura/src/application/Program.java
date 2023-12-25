package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Quantas pessoas vai ser digitadas? ");
		int num = sc.nextInt();
		
		//Vetores
		String[] nomes = new String[num];
		int[] idades = new int[num];
		double[] alturas = new double[num];
		double soma = 0.0;
		int cont = 0;
		
		for (int i=0; i <num; i++) {
			System.out.println("Dados da "+ (i+1)+ "a pessoa");
			System.out.print("Nome:  ");
			nomes[i] = sc.next();
			System.out.print("Idade: ");
			idades[i]= sc.nextInt();
			System.out.print("Altura: ");
			alturas[i]= sc.nextDouble();
			soma = soma + alturas[i];
			if(idades[i] < 16) {
				cont += 1;
			}
		}
		double mediaAlturas =soma/num;
		double percentagem = cont*100.0 / num;
		System.out.println("****************************");
		System.out.printf("Altura média: %.2f%n", mediaAlturas);
		System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", percentagem); // para que a percentagem aparece tem que pode dois % (%%)
		
		for(int i=0; i<num; i++) {
			if(idades[i] < 16) {
				System.out.println(nomes[i]);
			}
		}
		

		sc.close();

	}

}
