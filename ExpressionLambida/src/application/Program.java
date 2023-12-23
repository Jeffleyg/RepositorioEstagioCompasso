package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("NoteBook ", 1900.00));
		list.add(new Product("Tablets", 590.00));
		list.add(new Product("Cabo", 900.00));
		
		/*Comparator<Product> comp = new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
			}
		};	*/
		
		/*Comparator<Product> comp= (p1, p2) ->{ // essa expressão se chama error fonction
			return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
		};*/
		
		/*Comparator<Product> comp= (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());*/
		
		
		 list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
		
		for(Product p : list) {
			System.out.println(p);
		}
		
	}

}
