package entities;

public class Retangulo {
	public double largura;
	public double comprimento;
	
	
	// A area do retangulo
	public double area() {
		return largura * comprimento;
	}
	
	// o perimetro do retangulo
	public double perimetro() {
		return (largura * comprimento) * 2;
	}
	
	
	// a diagonal do retangulo
	public double diagonal() {
		return Math.sqrt(largura * largura + comprimento * comprimento);
	}
	

}
