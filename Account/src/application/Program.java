package application;

import entities.Account;

import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		//Polimorfismo quer dizer muitas formas
		
		
		Account x = new Account(1001, "Jeffley", 1000.0);
		Account y = new SavingsAccount(1001, "Kettia", 1000.0, 0.01);
		
		x.withdraw(50.0);
		y.withdraw(50.0);
		
		System.out.println(x.getBalance());
		System.out.println(y.getBalance());
		
	}
	
}	
