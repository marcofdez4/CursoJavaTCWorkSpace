package pruebas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Prueba {

	public static void main(String[] args) {
		System.out.println((int) ChronoUnit.DAYS.between(LocalDate.now().minusDays(7), LocalDate.now()));
	}
}
