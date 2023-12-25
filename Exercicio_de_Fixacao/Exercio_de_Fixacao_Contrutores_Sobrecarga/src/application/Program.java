package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;
		
		System.out.print("Enter account number: ");
		int number = sc.nextInt();
		System.out.println("Enter account holder: "); // conta titular
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Is there an initial deposit (y/n)? ");
		char reponse = sc.next().charAt(0);
		if(reponse == 'y') {
			System.out.println("Enter initial deposit value: ");
			double depositInitial = sc.nextDouble();
			account = new Account(number, holder, depositInitial);
		}
		else {
			account = new Account(number, holder);
		}
		
		System.out.println("*******************************");
		System.out.println("Accout data: ");
		System.out.println(account);
		System.out.println("*******************************");
		// para depositar
		System.out.print("Enter a deposit value: ");
		double deposit = sc.nextDouble();
		account.deposit(deposit);
		System.out.println("Updated account data: ");
		System.out.println(account);
		//para sacar
		System.out.println("*******************");
		System.out.print("Enter a withdraw value: ");
		double withdrawvalue = sc.nextDouble();
		account.withdraw(withdrawvalue);
		System.out.println("Updated account data: ");
		System.out.println(account);

		sc.close();
	}

}
