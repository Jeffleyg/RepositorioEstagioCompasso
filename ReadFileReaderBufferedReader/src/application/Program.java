package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		String path = "/home/jeffley/Documentos/doc/texto.txt";
		FileReader fr = null;
		BufferedReader br = null; // deixa mais rápido a leitura dos arquivos
		
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			//br = new BufferedReader(new FileReader(path));
			
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		finally {
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
		

	}

}
