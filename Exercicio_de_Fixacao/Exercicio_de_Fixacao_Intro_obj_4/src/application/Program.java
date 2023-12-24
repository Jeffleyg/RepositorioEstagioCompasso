package application;

import java.util.Locale;
import java.util.Scanner;

import entities.CurrencyConverter;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		CurrencyConverter currency = new CurrencyConverter();
		
		System.out.println("What is the dollar price ?");
		currency.priceDollar = sc.nextDouble();
		System.out.println("How many dollars will be bought? ");
		currency.price = sc.nextDouble();
		
		// out
		
		System.out.printf("Amount to be paid in reias = %.2f%n", currency.ReiasConverter());

	}

}
