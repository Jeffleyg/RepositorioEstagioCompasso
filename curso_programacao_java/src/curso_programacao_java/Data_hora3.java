package curso_programacao_java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Data_hora3 {

	public static void main(String[] args) {
		
		LocalDate d04 = LocalDate.parse("2023-12-16");
		LocalDateTime d05 = LocalDateTime.parse("2023-12-16T01:30:26");
		//Instant d06 = Instant.parse("2023-12-16T01:30:26Z");
		
		LocalDate pastWeekLocalDate = d04.minusDays(7);
		//LocalDate nextWeekLocalDate = d04.plusDays(7);
		LocalDate nextWeekLocalDate = d04.plusDays(7);
		
		System.out.println("pastWeekLocalDate = "+ pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = "+ nextWeekLocalDate);
		
		LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);
		
		System.out.println(" ");
		System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
		System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);
		
		
	}

}
