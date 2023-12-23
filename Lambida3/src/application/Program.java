package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {
	
	public static int compareProducts(Product p1, Product p2) {
		return p1.getPrice().compareTo(p2.getPrice());
	}

	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("TV", 900.00));
		list.add(new Product("NoteBook ", 1900.00));
		list.add(new Product("Tablets", 590.00));
		list.add(new Product("Cabo", 900.00));
		
		list.sort(Program::compareProducts);
		
		list.forEach(System.out::println);

	}

}
