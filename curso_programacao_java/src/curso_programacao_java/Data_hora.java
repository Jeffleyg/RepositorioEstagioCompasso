package curso_programacao_java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Data_hora {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

	
		LocalDate d01 =  LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		
		Instant d03 = Instant.now();
		LocalDate  d04 = LocalDate.parse("2024-12-16");
		LocalDateTime  d05 = LocalDateTime.parse("2024-12-16T01:30:26");
		Instant  d06 = Instant.parse("2024-12-16T01:30:26Z");
		Instant  d07 = Instant.parse("2024-12-16T01:30:26-03:00");
		
		LocalDate d08 = LocalDate.parse("17/12/2023", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("17/12/2023 01:30", fmt2);
		
		LocalDate d10 = LocalDate.of(2023,  12, 15);
		LocalDateTime d11 = LocalDateTime.of(2023, 12, 12, 1, 30);


		System.out.println("d01 = "+ d01.toString());
		System.out.println("d02 = "+ d02.toString());
		System.out.println("d03 = "+ d03.toString());
		System.out.println("d04 = "+ d04.toString());
		System.out.println("d05 = "+ d05.toString());
		System.out.println("d06 = "+ d06.toString());
		System.out.println("d07 = "+ d07.toString());
		System.out.println("d08 = "+ d08.toString());
		System.out.println("d09 = "+ d09.toString());
		System.out.println("d10 = "+ d10.toString());
		System.out.println("d11 = "+ d11.toString());
		
		System.out.println("d04 = "+ d04.format(fmt1));
		System.out.println("d04 = "+ fmt1.format(d04));
		System.out.println("d04 = "+ d04.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println("d05 = "+ d05.format(fmt2));
		System.out.println("d06 = "+ fmt3.format(d06));
		System.out.println("d05 = "+ d05.format(fmt4));
		System.out.println("d06 = "+ fmt5.format(d06));
		System.out.println("d06 = "+ d06.toString());



	}

}
