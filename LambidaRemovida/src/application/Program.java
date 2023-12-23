package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("NoteBook ", 1900.00));
		list.add(new Product("Tablets", 50.00));
		list.add(new Product("Cabo", 90.00));

		list.removeIf(p-> p.getPrice() >= 100.0);

		for(Product p : list) {
			System.out.println(p);
		}
		
		
		
	}

}
