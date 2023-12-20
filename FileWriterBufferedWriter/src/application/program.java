package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class program {

	public static void main(String[] args) {
		
		String[] lines = new String[] { "Good morning", "Good afternoon", "Good night"};
		
		String path = "/home/jeffley/Documentos/doc/texto1.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ // para que pode gravar o que já foi escrito tem que colocar "true".
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
