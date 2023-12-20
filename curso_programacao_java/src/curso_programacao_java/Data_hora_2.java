package curso_programacao_java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Data_hora_2 {

	public static void main(String[] args) {
		
		Instant d06 = Instant.parse("2023-12-16T01:30:26Z");
		
		LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

		
		System.out.println("r1 = "+ r1);
		System.out.println("r2 = "+ r2);
		System.out.println("r3 = "+ r3);
		System.out.println("r4 = "+ r4);
		
		
		
	}

}
