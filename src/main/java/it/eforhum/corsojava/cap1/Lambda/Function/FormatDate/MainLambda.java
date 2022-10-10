package it.eforhum.corsojava.cap1.Lambda.Function.FormatDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class MainLambda {
	public static void main(String[] args) {

		Function<LocalDate, String> formatDate = (date) -> {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return formatter.format(date);
		};

		String dateFormat = formatDate.apply(LocalDate.now());

		System.out.println(dateFormat);
	}
}
