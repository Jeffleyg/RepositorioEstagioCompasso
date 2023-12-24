package entities;

public class CurrencyConverter {
	public Double price;
	public Double priceDollar;
	
	
	public double ReiasConverter() {
		return (priceDollar * price) + (priceDollar * 0.06) * price ;
	}
	
	
}
