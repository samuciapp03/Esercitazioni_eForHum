package it.eforhum.corsojava.cap1.Lambda.FormatDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainLambda {
	public static void main(String[] args) {

		InterfaceLambda format = ((date) -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return formatter.format(date);
		});

		String dateFormat = format.formatDate(LocalDate.now());

		System.out.println(dateFormat);
	}
}
